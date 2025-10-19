package main.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Builder
@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Wizard {

    // TODO:DONE: Complete the entity fields

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false, unique = true)
    private String username; // The wizard's username (String, unique, not null)

    @Column(nullable = false)
    private String password; // The wizard's password (String, not null) - must be hashed

    @Column(nullable = false)
    private String avatarUrl; // URL of the wizard's avatar (String, not null)

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private WizardAlignment alignment; // The wizard’s alignment (String, not null)

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private House house; // The wizard’s house (House, not null)

    @OneToMany(mappedBy = "wizard")
    private List<Spell> spells; // List of spells the wizard has learned List<Spell>)

    @Column(nullable = false)
    private LocalDateTime createdOn; // When the wizard registered (LocalDateTime, not null)

    @Column(nullable = false)
    private LocalDateTime updatedOn; // When the wizard's information was last updated (LocalDateTime, not null)


    public void addSpell(Spell spell) {
        spells.add(spell);
        spell.setWizard(this);
    }
}
