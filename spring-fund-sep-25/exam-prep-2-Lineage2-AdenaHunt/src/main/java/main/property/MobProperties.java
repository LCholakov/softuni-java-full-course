package main.property;

import lombok.Data;
import main.config.YamlPropertySourceFactory;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.util.List;

@Data
@Configuration
@ConfigurationProperties
@PropertySource(value = "mob-details.yaml", factory = YamlPropertySourceFactory.class)
public class MobProperties {

    private List<MobDetail> mobs;

    @Data
    public static class MobDetail {
        private String name;
        private int[] levelRange;
        private String spawnArea;
        private String description;
        private String image;
        private double healthFactor;
        private double attackFactor;
        private double defenseFactor;
        private int[] adenaDrop;
        private int[] xpDrop;
    }
}
