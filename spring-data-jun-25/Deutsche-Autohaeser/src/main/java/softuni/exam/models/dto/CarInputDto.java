package softuni.exam.models.dto;

import com.google.gson.annotations.Expose;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import org.hibernate.validator.constraints.Length;
import softuni.exam.entities.Dealership;
import softuni.exam.models.entity.CarType;

public class CarInputDto {
    @Expose
    @NotNull
    @Length(min = 2, max = 30)
    private String brand;

    @Expose
    @NotNull
    @Length(min = 2, max = 30)
    private String model;

    @Expose
    @NotNull
    @Length(min = 17, max = 17)
    private String VIN;

    @Expose
    @NotNull
    @Positive
    private int mileage;

    @Expose
    @NotNull
    private CarType carType;

    @Expose
    @NotNull
    private Long dealership;

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
        return VIN;
    }

    public void setVin(String vin) {
        this.VIN = vin;
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

    public Long getDealership() {
        return dealership;
    }

    public void setDealership(Long dealership) {
        this.dealership = dealership;
    }
}
