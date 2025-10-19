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
public class Spell {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    // TODO:DONE: Complete the entity fields

    @Column(nullable = false)
    private String code; // The code of the spell (e.g., "LUMOS", "EXPELLIARMUS") (String, not null)

    @Column(nullable = false)
    private String name; // The name of the spell (String, not null)

    @Column(nullable = false)
    private String description; // A brief description of the spell (String, not null)

    @ManyToOne
    @JoinColumn(name = "wizard_id", nullable = false)
    private Wizard wizard; // The wizard who learned the spell (Wizard, not null)

    @Column
    @Enumerated(EnumType.STRING)
    private SpellCategory category; // The category of the spell (SpellCategory, not null)

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private SpellAlignment alignment; // The alignment of the spell (SpellAlignment, not null)

    @Column(nullable = false)
    private String image; // The image of the spell (String, not null)

    @Column
    private int power; // The power of the spell (int)

    @Column(nullable = false)
    private LocalDateTime createdOn; // Date when the spell was learned by the wizard (LocalDateTime, not null)
}
