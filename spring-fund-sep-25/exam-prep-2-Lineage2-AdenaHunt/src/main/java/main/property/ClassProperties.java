package main.property;

import lombok.Data;
import main.config.YamlPropertySourceFactory;
import main.model.BoosterType;
import main.model.PlayerClass;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.util.List;

@Data
@Configuration
@ConfigurationProperties
@PropertySource(value = "class-details.yaml", factory = YamlPropertySourceFactory.class)
public class ClassProperties {

    private List<ClassDetail> classes;

    @Data
    public static class ClassDetail {
        private PlayerClass playerClass;
        private int healthFactor;
        private int attackFactor;
        private int defenseFactor;
        private String bannerImg;
        private List<Booster> boosters;
    }

    @Data
    public static class Booster {
        private String name;
        private double value;
        private BoosterType type;
        private String icon;
    }
}
