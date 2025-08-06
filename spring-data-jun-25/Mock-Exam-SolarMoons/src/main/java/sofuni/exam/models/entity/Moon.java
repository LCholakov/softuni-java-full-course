package sofuni.exam.models.entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "moons")
public class Moon extends BaseEntity{
    @Column(name = "discovered", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date discovered;
    @Column(name = "distance_from_planet", nullable = true)
    private int distanceFromPlanet;
    @Column(name = "name", unique = true, nullable = false)
    private String name;
    @Column(name = "radius", nullable = false)
    private double radius;

    @ManyToOne
    @JoinColumn(name = "discoverer_id", nullable = false)
    private Discoverer discoverer;

    @ManyToOne
    @JoinColumn(name = "planet_id", nullable = false)
    private Planet planet;

    public Date getDiscovered() {
        return discovered;
    }

    public void setDiscovered(Date discovered) {
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

    public Discoverer getDiscoverer() {
        return discoverer;
    }

    public void setDiscoverer(Discoverer discoverer) {
        this.discoverer = discoverer;
    }

    public Planet getPlanet() {
        return planet;
    }

    public void setPlanet(Planet planet) {
        this.planet = planet;
    }
}
