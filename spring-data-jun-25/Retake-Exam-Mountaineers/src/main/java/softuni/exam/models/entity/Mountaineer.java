package softuni.exam.models.entity;

import jakarta.persistence.*;
import softuni.exam.models.entity.BaseEntity;
import softuni.exam.models.entity.Mountain;

import java.time.LocalDate;

@Entity
@Table(name = "mountaineers")
public class Mountaineer extends BaseEntity {
    @Column(name = "first_name", unique = true, nullable = false)
    private String firstName;

    @Column(name = "last_name", unique = true, nullable = false)
    private String lastName;

    @Column(name = "budget", nullable = false)
    private double budget;

    @Column(name = "age", nullable = false)
    private int age;

    @Column(name = "mountaineer_from", nullable = true)
    private LocalDate mountaneerFrom;
    
    @ManyToOne
    @JoinColumn(name = "climbing_mountain_id", nullable = true)
    private Mountain climbingMountainId;

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

    public LocalDate getMountaneerFrom() {
        return mountaneerFrom;
    }

    public void setMountaneerFrom(LocalDate mountaneerFrom) {
        this.mountaneerFrom = mountaneerFrom;
    }

    public Mountain getClimbingMountainId() {
        return climbingMountainId;
    }

    public void setClimbingMountainId(Mountain climbingMountainId) {
        this.climbingMountainId = climbingMountainId;
    }
}
