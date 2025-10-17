package app.subscription.service;

//all biz logic related to subscription will be here
//I want one object type bean to be created for this class

import app.subscription.model.Subscription;
import app.subscription.model.SubscriptionPeriod;
import app.subscription.model.SubscriptionStatus;
import app.subscription.model.SubscriptionType;
import app.subscription.repository.SubscriptionRepository;
import app.transaction.model.Transaction;
import app.transaction.model.TransactionStatus;
import app.user.model.User;
import app.user.service.UserService;
import app.wallet.repository.WalletRepository;
import app.wallet.service.WalletService;
import app.web.dto.UpgradeRequest;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Optional;

@Service
public class SubscriptionService {

    private final SubscriptionRepository subscriptionRepository;
    private final WalletRepository walletRepository;
    private final WalletService walletService;

    @Autowired
    public SubscriptionService(SubscriptionRepository subscriptionRepository, WalletRepository walletRepository, WalletService walletService) {
        this.subscriptionRepository = subscriptionRepository;
        this.walletRepository = walletRepository;
        this.walletService = walletService;
    }

    public Subscription createDefaultSubscription(User user) {

        Subscription subscription = Subscription.builder()
                .owner(user)
                .status(SubscriptionStatus.ACTIVE)
                .period(SubscriptionPeriod.MONTHLY)
                .type(SubscriptionType.DEFAULT)
                .price(BigDecimal.ZERO)
                .renewalAllowed(true)
                .createdOn(LocalDateTime.now())
                .expiryOn(LocalDateTime.now().plusMonths(1))
                .build();

        return subscriptionRepository.save(subscription);
    }

    public Transaction upgrade(User user, UpgradeRequest upgradeRequest, SubscriptionType subscriptionType) {

        Optional<Subscription> currentlyActiveSubscriptionOpt = subscriptionRepository.findByStatusAndOwnerId(SubscriptionStatus.ACTIVE, user.getId());
        if(currentlyActiveSubscriptionOpt.isEmpty()) {
            throw new RuntimeException("No active subscription was found for user with id [%s].".formatted(user.getId()));
        }

        Subscription currentlyActiveSubscription = currentlyActiveSubscriptionOpt.get();
        BigDecimal subscriptionPrice = getUpgradePrice(subscriptionType, upgradeRequest.getPeriod());
        String chargeDescription = "Upgrade request for %s %s".formatted(upgradeRequest.getPeriod().getDisplayName(), subscriptionType);
        Transaction chargeResultTransaction = walletService.withdraw(user, upgradeRequest.getWalletId(), subscriptionPrice, chargeDescription);
        if(chargeResultTransaction.getStatus() == TransactionStatus.FAILED) {
            return chargeResultTransaction;
        }

        LocalDateTime currentTime = LocalDateTime.now();
        LocalDateTime expiryDate;

        if(upgradeRequest.getPeriod() == SubscriptionPeriod.MONTHLY) {
            expiryDate = currentTime.plusMonths(1).truncatedTo(ChronoUnit.DAYS);
        } else {
            expiryDate = currentTime.plusYears(1).truncatedTo(ChronoUnit.DAYS);
        }

        Subscription newActiveSubscription = Subscription.builder()
                .owner(user)
                .status(SubscriptionStatus.ACTIVE)
                .period(upgradeRequest.getPeriod())
                .type(subscriptionType)
                .price(subscriptionPrice)
                .renewalAllowed(upgradeRequest.getPeriod() == SubscriptionPeriod.MONTHLY)
                .createdOn(currentTime)
                .expiryOn(expiryDate)
                .build();

        currentlyActiveSubscription.setStatus(SubscriptionStatus.COMPLETED);
        currentlyActiveSubscription.setExpiryOn(LocalDateTime.now());

        subscriptionRepository.save(currentlyActiveSubscription);
        subscriptionRepository.save(newActiveSubscription);

        return chargeResultTransaction;
    }

    private BigDecimal getUpgradePrice(SubscriptionType type, @NotNull SubscriptionPeriod period) {
        if(type == SubscriptionType.DEFAULT) {
            return BigDecimal.ZERO;
        } else if(type == SubscriptionType.PREMIUM && period == SubscriptionPeriod.MONTHLY) {
            return BigDecimal.valueOf(19.99);
        } else if(type == SubscriptionType.PREMIUM && period == SubscriptionPeriod.YEARLY) {
            return BigDecimal.valueOf(199.99);
        } else if(type == SubscriptionType.ULTIMATE && period == SubscriptionPeriod.MONTHLY) {
            return BigDecimal.valueOf(49.99);
        } else if(period == SubscriptionPeriod.YEARLY) {
            return BigDecimal.valueOf(499.99);
        }

        throw new RuntimeException("Price not found for type [%s] and period [%s]".formatted(type, period));
    }
}
