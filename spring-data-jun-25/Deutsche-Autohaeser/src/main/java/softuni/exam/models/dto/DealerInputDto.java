package softuni.exam.models.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import org.hibernate.validator.constraints.Length;
import softuni.exam.entities.Car;

import java.time.LocalDate;

@XmlAccessorType(XmlAccessType.FIELD)
public class DealerInputDto {
    @XmlElement(name = "average_monthly_turnover")
    @NotNull
    @Positive
    private double averageMonthlyTurnover;

    @XmlElement(name = "birthday")
    private String birthday;

    @XmlElement(name = "first_name")
    @NotNull
    @Length(min = 2, max = 30)
    private String firstName;

    @XmlElement(name = "last_name")
    @NotNull
    @Length(min = 2, max = 30)
    private String lastName;

    @XmlElement(name = "salary")
    @NotNull
    @Positive
    private double salary;

    @XmlElement(name = "offering_car_id")
    @NotNull
    private Car offeringCar;

    public double getAverageMonthlyTurnover() {
        return averageMonthlyTurnover;
    }

    public void setAverageMonthlyTurnover(double averageMonthlyTurnover) {
        this.averageMonthlyTurnover = averageMonthlyTurnover;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

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

    public Car getOfferingCar() {
        return offeringCar;
    }

    public void setOfferingCar(Car offeringCar) {
        this.offeringCar = offeringCar;
    }
}

//
//    <dealer>
//        <average_monthly_turnover>176858.79</average_monthly_turnover>
//        <birthday>1989-01-01</birthday>
//        <first_name>Drake</first_name>
//        <last_name>Hawthorne</last_name>
//        <salary>207615.71</salary>
//        <offering_car_id>50</offering_car_id>
//    </dealer>