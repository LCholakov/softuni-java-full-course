package main.service;

import jakarta.validation.Valid;
import main.model.Party;
import main.model.Player;
import main.model.PlayerClass;
import main.property.ClassProperties;
import main.property.ClassProperties.ClassDetail;
import main.repository.PlayerRepository;
import main.web.dto.LoginRequest;
import main.web.dto.RegisterRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class PlayerService {
    private final PlayerRepository playerRepository;
    private final PasswordEncoder passwordEncoder;
    private final ClassProperties classProperties;

    @Autowired
    public PlayerService(PlayerRepository playerRepository, PasswordEncoder passwordEncoder, ClassProperties classProperties) {
        this.playerRepository = playerRepository;
        this.passwordEncoder = passwordEncoder;
        this.classProperties = classProperties;
    }


    public void createNewPlayer(@Valid RegisterRequest registerRequest) {
        Player player = Player.builder()
                .username(registerRequest.getUsername())
                .password(passwordEncoder.encode(registerRequest.getPassword()))
                .nickname(registerRequest.getNickname())
                .level(1)
                .xp(100)
                .createdOn(LocalDateTime.now())
                .updatedOn(LocalDateTime.now())
                .build();

        playerRepository.save(player);
    }

    public Player login(LoginRequest loginRequest) {
        Player player = playerRepository.findByUsername(loginRequest.getUsername())
                .orElseThrow(() -> new IllegalArgumentException("User with username " + loginRequest.getUsername() + " not found."));

        if(!passwordEncoder.matches(loginRequest.getPassword(), player.getPassword())) {
            throw new RuntimeException("Username or password is incorrect.");
        }

        return player;
    }

    public Player getById(UUID playerId) {
        return playerRepository.findById(playerId)
                .orElseThrow(() -> new RuntimeException("Player not found."));

    }

    public void selectClass(UUID playerId, PlayerClass playerClass) {
        Player player = getById(playerId);
        ClassDetail classDetails = classProperties.getDetailsByPlayerClass(playerClass);

        player.setPlayerClass(playerClass);
        player.setBannerImg(classDetails.getBannerImg());
        player.setAttack(classDetails.getAttackFactor() * player.getLevel());
        player.setDefense(classDetails.getDefenseFactor() * player.getLevel());
        player.setHealth(classDetails.getHealthFactor() * player.getLevel());

        player.setUpdatedOn(LocalDateTime.now());

        playerRepository.save(player);
    }

    public List<ClassProperties.Booster> getBoosters(PlayerClass playerClass) {
        return classProperties.getDetailsByPlayerClass(playerClass).getBoosters();
    }

    public List<Player> findAllByParty(Party party) {
        if(party == null) {
            return List.of();
        }
        return playerRepository.findAllByParty_Id(party.getId());
    }

    public List<Player> findAllFreePlayersForInvite(Player currentPlayer) {
        return playerRepository
                .findAll().stream()
                .filter(p -> p.getPlayerClass() != null && p.getParty() == null && !p.getId().equals(currentPlayer.getId()))
                .toList();
    }

    public void update(Player player) {
        playerRepository.save(player);
    }
}
