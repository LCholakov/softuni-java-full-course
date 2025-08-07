package softuni.exam.models.dto;

import com.google.gson.annotations.Expose;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import org.hibernate.validator.constraints.Length;
import softuni.exam.models.entity.Country;
import softuni.exam.models.entity.enums.ElevationCategory;

public class MountainInputDto {

    @Expose
    @NotNull
    @Length(min = 2, max = 30)
    private String name;

    @Expose
    @NotNull
    @Positive
    @Max(value = 9999)
    private int elevation;

    @Expose
    private ElevationCategory elevationCategory;

    @Expose
    @NotNull
    private boolean hardToReach;

    @Expose
    private Long country;

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

    public Long getCountry() {
        return country;
    }

    public void setCountry(Long country) {
        this.country = country;
    }
}
