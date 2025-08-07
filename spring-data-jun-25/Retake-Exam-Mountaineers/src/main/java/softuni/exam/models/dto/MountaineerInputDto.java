package softuni.exam.models.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import softuni.exam.models.entity.Mountain;

import java.time.LocalDate;

@XmlAccessorType(XmlAccessType.FIELD)
public class MountaineerInputDto {
    @XmlElement(name = "first_name")
    @NotNull
    private String firstName;

    @XmlElement(name = "last_name")
    @NotNull
    private String lastName;

    @XmlElement(name = "budget")
    @NotNull
    @Positive
    private double budget;

    @XmlElement(name = "age")
    @NotNull
    @Positive
    @Min(value = 18)
    @Max(value = 80)
    private int age;

    @XmlElement(name = "mountaineer_from")
    private String mountaneerFrom;

    @XmlElement(name = "climbing_mountain_id")
    private Long climbingMountain;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public double getBudget() {
        return budget;
    }

    public void setBudget(double budget) {
        this.budget = budget;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getMountaneerFrom() {
        return mountaneerFrom;
    }

    public void setMountaneerFrom(String mountaneerFrom) {
        this.mountaneerFrom = mountaneerFrom;
    }

    public Long getClimbingMountain() {
        return climbingMountain;
    }

    public void setClimbingMountain(Long climbingMountain) {
        this.climbingMountain = climbingMountain;
    }
}
