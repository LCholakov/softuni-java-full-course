package softuni.exam.models.entity.enums;

import jakarta.persistence.*;

@Entity
@Table(name = "mountains")
public class Mountain extends BaseEntity {
    @Column(name = "name", unique = true, nullable = false)
    private String name;

    @Column(name = "elevation", nullable = false)
    private int elevation;
    
    @Column(name = "elevation_category", nullable = true)
    @Enumerated(EnumType.STRING)    
    private ElevationCategory elevationCategory;
    
    @Column(name = "hard_to_reach", nullable = false)
    private boolean hardToReach;
    
    @ManyToOne
    @JoinColumn(name = "country_id", nullable = true)
    private Country countryId;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getElevation() {
        return elevation;
    }

    public void setElevation(int elevation) {
        this.elevation = elevation;
    }

    public ElevationCategory getElevationCategory() {
        return elevationCategory;
    }

    public void setElevationCategory(ElevationCategory elevationCategory) {
        this.elevationCategory = elevationCategory;
    }

    public boolean isHardToReach() {
        return hardToReach;
    }

    public void setHardToReach(boolean hardToReach) {
        this.hardToReach = hardToReach;
    }

    public Country getCountryId() {
        return countryId;
    }

    public void setCountryId(Country countryId) {
        this.countryId = countryId;
    }
}
