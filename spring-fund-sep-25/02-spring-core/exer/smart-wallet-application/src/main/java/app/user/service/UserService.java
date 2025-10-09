package app.user.service;

import app.subscription.model.Subscription;
import app.subscription.service.SubcriptionService;
import app.user.model.User;
import app.user.model.UserRole;
import app.user.repository.UserRepository;
import app.wallet.model.Wallet;
import app.wallet.repository.WalletRepository;
import app.wallet.service.WalletService;
import app.web.dto.LoginRequest;
import app.web.dto.RegisterRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Slf4j
@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final WalletRepository walletRepository;
    private final WalletService walletService;
    private final SubcriptionService subcriptionService;

    @Autowired // i don't care how, but userRepos is a bean, so give it to me here.
    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder, WalletRepository walletRepository, WalletService walletService, SubcriptionService subcriptionService) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.walletRepository = walletRepository;
        this.walletService = walletService;
        this.subcriptionService = subcriptionService;
    }

    public User login(LoginRequest loginRequest) {
        Optional<User> optionalUser = userRepository.findByUsername(loginRequest.getUsername());
        if (optionalUser.isPresent()) {
            throw new RuntimeException("Incorrect username or password.");
        }

        String rawPwd = loginRequest.getPassword();
        String hashedPwd = optionalUser.get().getPassword();

        if (!passwordEncoder.matches(rawPwd, hashedPwd)) {
            throw new RuntimeException("Incorrect username or password.");
        }

        return optionalUser.get();
    }

    @Transactional
    public User register(RegisterRequest registerRequest) {
        Optional<User> optionalUser = userRepository.findByUsername(registerRequest.getUsername());
        if (optionalUser.isPresent()) {
            throw new RuntimeException("User with [%s] username already exists.".formatted(registerRequest.getUsername()));
        }

        User user = User.builder()
                .username(registerRequest.getUsername())
                .password(passwordEncoder.encode(registerRequest.getPassword()))
                .role(UserRole.USER)
                .country(registerRequest.getCountry())
                .active(true)
                .createdOn(LocalDateTime.now())
                .updatedOn(LocalDateTime.now())
                .build();

        user = userRepository.save(user); // get user with an ID created
        Wallet defaultWallet = walletService.createDefaultWallet(user);
        Subscription defaultSubscription = subcriptionService.createDefaultSubscription(user);

        user.setWallets(List.of(defaultWallet));
        user.setSubscriptions(List.of(defaultSubscription));

        log.info("New user profile was registered in the system for user [%s]".formatted(user));

        return user;
    }

    public List<User> getAll() {
        return userRepository.findAll();
    }

    public User getByUsername(String username) {
        return userRepository.findByUsername(username).orElseThrow(() -> new RuntimeException("User with [%s] username already exists.".formatted(username)));

    }

    public User getById(UUID id) {
        return userRepository.findById(id).orElseThrow(() -> new RuntimeException("User with [%s] id not found.".formatted(id)));
    }
}
