package sofuni.exam.models.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "moons")
public class Moon extends BaseEntity{
    @Column(name = "discovered", nullable = false)
//    @Temporal(TemporalType.DATE)
    private LocalDate discovered;
    @Column(name = "distance_from_planet", nullable = true)
    private int distanceFromPlanet;
    @Column(name = "name", unique = true, nullable = false)
    private String name;
    @Column(name = "radius", nullable = false)
    private double radius;

    @ManyToOne
    @JoinColumn(name = "discoverer_id", nullable = false)
    private Discoverer discovererId;

    @ManyToOne
    @JoinColumn(name = "planet_id", nullable = false)
    private Planet planetId;

    public LocalDate getDiscovered() {
        return discovered;
    }

    public void setDiscovered(LocalDate discovered) {
        this.discovered = discovered;
    }

    public int getDistanceFromPlanet() {
        return distanceFromPlanet;
    }

    public void setDistanceFromPlanet(int distanceFromPlanet) {
        this.distanceFromPlanet = distanceFromPlanet;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public Discoverer getDiscovererId() {
        return discovererId;
    }

    public void setDiscovererId(Discoverer discoverer) {
        this.discovererId = discoverer;
    }

    public Planet getPlanetId() {
        return planetId;
    }

    public void setPlanetId(Planet planet) {
        this.planetId = planet;
    }
}
