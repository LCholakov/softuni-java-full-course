package softuni.exam.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "dealers", uniqueConstraints = {@UniqueConstraint(name = "unique_dealer_name", columnNames = {"first_name", "last_name"})})

public class Dealer extends BaseEntity{
    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "salary", nullable = false)
    private double salary;

    @Column(name = "average_monthly_turnover", nullable = false)
    private double averageMonthlyTurnover;

    @Column(name = "birthday")
    private LocalDate birthday;

    @ManyToOne
    @JoinColumn(name = "offering_car_id")
    private Car offeringCarId;

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

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public double getAverageMonthlyTurnover() {
        return averageMonthlyTurnover;
    }

    public void setAverageMonthlyTurnover(double averageMonthlyTurnover) {
        this.averageMonthlyTurnover = averageMonthlyTurnover;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public Car getOfferingCarId() {
        return offeringCarId;
    }

    public void setOfferingCarId(Car offeringCarId) {
        this.offeringCarId = offeringCarId;
    }
}
