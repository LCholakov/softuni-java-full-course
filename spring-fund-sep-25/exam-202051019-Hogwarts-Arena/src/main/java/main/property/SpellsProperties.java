package main.property;

import jakarta.annotation.PostConstruct;
import lombok.Data;
import main.config.YamlPropertySourceFactory;
import main.model.SpellAlignment;
import main.model.SpellCategory;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.util.List;

@Data
@Configuration
@ConfigurationProperties
@PropertySource(value = "spells.yaml", factory = YamlPropertySourceFactory.class)
public class SpellsProperties {
    // TODO:DONE: Load spell properties here.
    // Hint: Make an inner public class here that matches the structure of spells.yaml file

    private List<SpellDetails> spells;

    @Data
    public static class SpellDetails {
        private String code; // "LUMOS"
        private String name; // "Lumos"
        private String image; // "/images/spells/lumos.png"
        private SpellCategory category; // "UTILITY"
        private SpellAlignment alignment; // "LIGHT"
        private int minLearned; // 0
        private int power; // 20
        private String description; // "Produces light at the wand tip to illuminate darkness."
    }

//    test if this loads
//    @PostConstruct
//    public void test() {
//        System.out.println("Loaded mob details: " + spells.size());
//    }
}
