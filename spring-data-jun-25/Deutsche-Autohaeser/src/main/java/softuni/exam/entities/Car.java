package softuni.exam.entities;

import jakarta.persistence.*;
import softuni.exam.models.entity.CarType;

@Entity
@Table(name = "cars")
public class Car extends BaseEntity {
    @Column(name = "brand", nullable = false)
    private String brand;

    @Column(name = "model", nullable = false)
    private String model;

    @Column(name = "vin", nullable = false, unique = true)
    private String vin;

    @Column(name = "mileage", nullable = false)
    private int mileage;

    @Column(name = "car_type", nullable = false)
    @Enumerated(EnumType.STRING)
    private CarType carType;

    @ManyToOne
    @JoinColumn(name = "dealership_id")
    private Dealership dealershipId;

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public int getMileage() {
        return mileage;
    }

    public void setMileage(int mileage) {
        this.mileage = mileage;
    }

    public CarType getCarType() {
        return carType;
    }

    public void setCarType(CarType carType) {
        this.carType = carType;
    }

    public Dealership getDealershipId() {
        return dealershipId;
    }

    public void setDealershipId(Dealership dealershipId) {
        this.dealershipId = dealershipId;
    }
}
