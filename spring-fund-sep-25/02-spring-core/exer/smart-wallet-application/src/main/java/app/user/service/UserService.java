package app.user.service;

import app.subscription.service.SubcriptionService;
import app.user.model.User;
import app.user.model.UserRole;
import app.user.repository.UserRepository;
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
import java.util.Optional;

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
        Optional<User> optionalUser = userRepository.findByUsername(loginRequest.username());
        if (optionalUser.isPresent()) {
            throw new RuntimeException("Incorrect username or password.");
        }

        String rawPwd = loginRequest.password();
        String hashedPwd = optionalUser.get().getPassword();

        if (!passwordEncoder.matches(rawPwd, hashedPwd)) {
            throw new RuntimeException("Incorrect username or password.");
        }

        return optionalUser.get();
    }

    @Transactional
    public void register(RegisterRequest registerRequest) {
        Optional<User> optionalUser = userRepository.findByUsername(registerRequest.username());
        if (optionalUser.isPresent()) {
            throw new RuntimeException("User with [%s] username already exists.".formatted(registerRequest.username()));
        }

        User user = User.builder()
                .username(registerRequest.username())
                .password(passwordEncoder.encode(registerRequest.password()))
                .role(UserRole.USER)
                .country(registerRequest.country())
                .active(true)
                .createdOn(LocalDateTime.now())
                .updatedOn(LocalDateTime.now())
                .build();

        user = userRepository.save(user); // get user with an ID created
        walletService.createDefaultWallet(user);
        subcriptionService.createDefaultSubscription(user);

        log.info("New user profile was registered in the system for user [%s]".formatted(user));
    }
}
