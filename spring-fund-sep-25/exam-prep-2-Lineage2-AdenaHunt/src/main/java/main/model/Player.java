package main.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Builder
@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false, unique = true)
    private String nickname;

    @Enumerated(EnumType.STRING)
    private PlayerClass playerClass;

    @Column
    private String bannerImg;

    @ManyToOne
    @JoinColumn(name = "party_id")
    private Party party;

    @Column
    private int level;

    @Column
    private double health;

    @Column
    private double attack;

    @Column
    private double defense;

    @Column
    private double xp;

    @Column
    private int adena;

    @Column(nullable = false)
    private LocalDateTime createdOn;

    @Column(nullable = false)
    private LocalDateTime updatedOn;

}

