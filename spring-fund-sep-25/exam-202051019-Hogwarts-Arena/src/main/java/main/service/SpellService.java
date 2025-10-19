package main.service;

import main.model.Spell;
import main.model.Wizard;
import main.property.SpellsProperties;
import main.property.SpellsProperties.SpellDetails;
import main.repository.SpellRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class SpellService {
    private final SpellRepository spellRepository;

    public SpellService(SpellRepository spellRepository) {
        this.spellRepository = spellRepository;
    }


    public Spell createSpell(Wizard wizard, SpellDetails spellDetails) {
        Spell spell = Spell.builder()
                .code(spellDetails.getCode())
                .name(spellDetails.getName())
                .description(spellDetails.getDescription())
                .wizard(wizard)
                .category(spellDetails.getCategory())
                .alignment(spellDetails.getAlignment())
                .image(spellDetails.getImage())
                .power(spellDetails.getPower())
                .createdOn(LocalDateTime.now())
                .build();

        spellRepository.save(spell);
        return spell;
    }
}
