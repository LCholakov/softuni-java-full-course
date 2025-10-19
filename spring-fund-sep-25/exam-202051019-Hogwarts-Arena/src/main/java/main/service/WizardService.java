package main.service;

import jakarta.validation.Valid;
import main.exception.ExamException;
import main.model.Spell;
import main.model.SpellAlignment;
import main.model.Wizard;
import main.model.WizardAlignment;
import main.property.SpellsProperties;
import main.property.SpellsProperties.SpellDetails;
import main.repository.WizardRepository;
import main.web.dto.EditRequest;
import main.web.dto.LoginRequest;
import main.web.dto.RegisterRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

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

//        all of these spell methods should be in the spell service
//        will move if time left
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

    public Wizard login(LoginRequest loginRequest) {


        Wizard wizard = wizardRepository.findByUsername(loginRequest.getUsername())
                .orElseThrow(() -> new ExamException("User with username " + loginRequest.getUsername() + " not found."));

        if(!passwordEncoder.matches(loginRequest.getPassword(), wizard.getPassword())) {
            throw new ExamException("Username or password is incorrect.");
        }

        return wizard;
    }

    public Wizard getWizardById(UUID wizardId) {
        return wizardRepository.findById(wizardId)
                .orElseThrow(() -> new ExamException("Wizard not found"));
    }

    public List<Spell> getAllSpells(Wizard wizard) {
        List<SpellDetails> allSpellDetails = wizardProperties.getSpells();
        return allSpellDetails.stream()
                .map(spellDetail -> {
                    return Spell.builder()
                            .name(spellDetail.getName())
                            .image(spellDetail.getImage())
                            .category(spellDetail.getCategory())
                            .alignment(spellDetail.getAlignment())
                            .power(spellDetail.getPower())
                            .description(spellDetail.getDescription())
                            .build();
                }).toList();
    }

    public List<Spell> getAvailableSpells(Wizard wizard) {
        List<Spell> learnedSpells = wizard.getSpells();
        List<SpellDetails> allSpellDetails = wizardProperties.getSpells();

        List<String> learnedSpellNames = learnedSpells.stream()
                .map(Spell::getName)
                .toList();

        return allSpellDetails.stream()
                .filter(spellDetail -> spellDetail.getMinLearned() <= wizard.getSpells().size())
                .filter(spellDetail -> !learnedSpellNames.contains(spellDetail.getName()))
                .map(spellDetail -> {
                    return Spell.builder()
                            .code(spellDetail.getCode())
                            .name(spellDetail.getName())
                            .description(spellDetail.getDescription())
                            .category(spellDetail.getCategory())
                            .alignment(spellDetail.getAlignment())
                            .image(spellDetail.getImage())
                            .power(spellDetail.getPower())
                            .build();
                }).toList();
    }

    public List<Spell> getLockedSpells(Wizard wizard) {
        List<SpellDetails> allSpellDetails = wizardProperties.getSpells();
        return allSpellDetails.stream()
                .filter(spellDetail -> spellDetail.getMinLearned() > wizard.getSpells().size())
                .map(spellDetail -> {
                    return Spell.builder()
                            .code(spellDetail.getCode())
                            .name(spellDetail.getName())
                            .description(spellDetail.getDescription())
                            .category(spellDetail.getCategory())
                            .alignment(spellDetail.getAlignment())
                            .image(spellDetail.getImage())
                            .power(spellDetail.getPower())
                            .build();
                }).toList();
    }

    public void learnSpell(UUID wizardId, String spellCode) {
        Wizard wizard = getWizardById(wizardId);
        List<SpellDetails> allSpellDetails = wizardProperties.getSpells();

        SpellDetails spellToLearnDetails = allSpellDetails.stream()
                .filter(spellDetail -> spellDetail.getCode().equals(spellCode))
                .findFirst()
                .orElseThrow(() -> new ExamException("Spell with code " + spellCode + " not found."));

        Spell newSpell = spellService.createSpell(wizard, spellToLearnDetails);
        if(wizard.getAlignment() == WizardAlignment.LIGHT && newSpell.getAlignment() == SpellAlignment.DARK) {
            wizard.setAlignment(WizardAlignment.DARK);
        }
        wizard.getSpells().add(newSpell);
        wizard.setUpdatedOn(LocalDateTime.now());

        wizardRepository.save(wizard);
    }

    public void updateWizardProfile(UUID wizardId, EditRequest editRequest) {
        Wizard wizard = getWizardById(wizardId);
        wizard.setUsername(editRequest.getUsername());
        wizard.setAvatarUrl(editRequest.getAvatarUrl());
        wizard.setUpdatedOn(LocalDateTime.now());

        wizardRepository.save(wizard);
    }

    public void changeWizardAlignmentToDark(UUID wizardId) {
        Wizard wizard = getWizardById(wizardId);
        wizard.setAlignment(WizardAlignment.DARK);
        wizard.setUpdatedOn(LocalDateTime.now());

        wizardRepository.save(wizard);
    }
}
