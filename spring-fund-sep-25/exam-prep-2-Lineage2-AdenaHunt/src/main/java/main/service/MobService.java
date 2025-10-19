package main.service;

import main.model.Mob;
import main.model.MobType;
import main.property.MobProperties;
import main.property.MobProperties.MobDetail;
import main.repository.MobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Random;

@Service
public class MobService {
    private final MobRepository mobRepository;
    private final MobProperties mobProperties;

    @Autowired
    public MobService(MobRepository mobRepository, MobProperties mobProperties) {
        this.mobRepository = mobRepository;
        this.mobProperties = mobProperties;
    }

    public Mob create(MobDetail mobDetails) {
        Random random = new Random();
        int level = random.nextInt(mobDetails.getLevelRange()[0], mobDetails.getLevelRange()[1] + 1);
        int adenaDrop = random.nextInt(mobDetails.getAdenaDrop()[0], mobDetails.getAdenaDrop()[1] + 1);
        int xpDrop = random.nextInt(mobDetails.getXpDrop()[0], mobDetails.getXpDrop()[1] + 1);

        MobType type = MobType.values()[random.nextInt(0, MobType.values().length)];
        double statMultiplier = 1.0;
        int dropMultiplier = 1;
        if (type == MobType.BLUE_CHAMPION) {
            statMultiplier = 1.05;
            dropMultiplier = 2;
        } else if (type == MobType.RED_CHAMPION) {
            statMultiplier = 1.1;
            dropMultiplier = 3;
        }

        Mob mob = Mob.builder()
                .name(mobDetails.getName())
                .level(level)
                .spawnArea(mobDetails.getSpawnArea())
                .description(mobDetails.getDescription())
                .health(mobDetails.getHealthFactor() * level * statMultiplier)
                .attack(mobDetails.getAttackFactor() * level * statMultiplier)
                .defense(mobDetails.getDefenseFactor() * level * statMultiplier)
                .adenaDrop(adenaDrop * dropMultiplier)
                .xpDrop(xpDrop * dropMultiplier)
                .alive(true)
                .type(type)
                .imageUrl(mobDetails.getImage())
                .createdOn(java.time.LocalDateTime.now())
                .updatedOn(java.time.LocalDateTime.now())
                .build();

        return mobRepository.save(mob);
    }

    public List<Mob> findTop3Mobs() {
        List<Mob> mobs = mobRepository.findAll();
        mobs.sort(Comparator.comparing(Mob::getCreatedOn).reversed());

        return mobs.stream().limit(3).toList();
    }

    public List<Mob> getAll() {
        return mobRepository.findAll();
    }
}
