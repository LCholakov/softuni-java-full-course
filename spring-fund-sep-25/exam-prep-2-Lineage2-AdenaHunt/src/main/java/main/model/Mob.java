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
public class Mob {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false)
    private String name;

    @Column
    private int level;

    @Column
    private double health;
    @Column
    private double attack;

    @Column
    private double defense;

    @Column
    private boolean alive;

    @Column
    private int adenaDrop;

    @Column
    private int xpDrop;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private MobType type;

    @Column(nullable = false)
    private String imageUrl;

    @Column(nullable = false)
    private String spawnArea;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private LocalDateTime createdOn;

    @Column(nullable = false)
    private LocalDateTime updatedOn;

}

