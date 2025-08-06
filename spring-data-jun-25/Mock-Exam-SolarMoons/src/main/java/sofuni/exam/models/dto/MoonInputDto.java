package sofuni.exam.models.dto;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import org.hibernate.validator.constraints.Length;
import sofuni.exam.models.entity.Discoverer;
import sofuni.exam.models.entity.Planet;

import java.util.Date;

@XmlAccessorType(XmlAccessType.FIELD)
public class MoonInputDto {
    @XmlElement(name = "name")
    @Length(min = 2, max = 10)
    @NotNull
    private String name;

    @XmlElement(name = "discovered")
    @NotNull
//    @Temporal(TemporalType.DATE)
    private String discovered;

    @XmlElement(name = "distance_from_planet")
    @Positive
    private int distanceFromPlanet;

    @XmlElement(name = "radius")
    @Positive
    @NotNull
    private double radius;

    @XmlElement(name = "discoverer_id")
    @NotNull
    private Long discoverer;

    @XmlElement(name = "planet_id")
    @NotNull
    private Long planet;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDiscovered() {
        return discovered;
    }

    public void setDiscovered(String discovered) {
        this.discovered = discovered;
    }

    public int getDistanceFromPlanet() {
        return distanceFromPlanet;
    }

    public void setDistanceFromPlanet(int distanceFromPlanet) {
        this.distanceFromPlanet = distanceFromPlanet;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public Long getDiscoverer() {
        return discoverer;
    }

    public void setDiscoverer(Long discoverer) {
        this.discoverer = discoverer;
    }

    public Long getPlanet() {
        return planet;
    }

    public void setPlanet(Long planet) {
        this.planet = planet;
    }
}
