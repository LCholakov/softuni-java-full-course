package main.service;

import jakarta.validation.Valid;
import main.exception.ExamException;
import main.model.Spell;
import main.model.Wizard;
import main.property.SpellsProperties;
import main.property.SpellsProperties.SpellDetails;
import main.repository.WizardRepository;
import main.web.dto.RegisterRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class WizardService {

    private final WizardRepository wizardRepository;
    private final PasswordEncoder passwordEncoder;
    private final SpellsProperties wizardProperties;
    private final SpellService spellService;

    @Autowired
    public WizardService(WizardRepository wizardRepository, PasswordEncoder passwordEncoder, SpellsProperties wizardProperties, SpellService spellService) {
        this.wizardRepository = wizardRepository;
        this.passwordEncoder = passwordEncoder;
        this.wizardProperties = wizardProperties;
        this.spellService = spellService;
    }


    public void createNewWizard(@Valid RegisterRequest registerRequest) {

        Wizard wizard = Wizard.builder()
                .username(registerRequest.getUsername())
                .password(passwordEncoder.encode(registerRequest.getPassword()))
                .avatarUrl(registerRequest.getAvatarUrl())
                .house(registerRequest.getHouse())
                .alignment(registerRequest.getAlignment())
                .createdOn(LocalDateTime.now())
                .updatedOn(LocalDateTime.now())
                .build();

        wizardRepository.save(wizard);

//        this would be better in its own method prbly
        List<SpellDetails> startingSpells = wizardProperties.getStartingSpells();
        if(startingSpells.isEmpty()) {
            throw new ExamException("No starting spells defined in properties.");
        }

        SpellDetails startingSpellDetails = startingSpells.get(new Random().nextInt(0, startingSpells.size()));
        Spell spell = spellService.createSpell(wizard, startingSpellDetails);

        // initialize spell list and add firtst spell
        List<Spell> spellList = new ArrayList<>();
        spellList.add(spell);
        wizard.setSpells(spellList);

        wizardRepository.save(wizard);

    }
}
