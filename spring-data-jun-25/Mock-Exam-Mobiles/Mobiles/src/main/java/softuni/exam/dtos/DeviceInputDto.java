package softuni.exam.dtos;

import com.google.gson.annotations.Expose;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorOrder;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import org.hibernate.validator.constraints.Length;
import softuni.exam.entities.Sale;
import softuni.exam.enums.DevicyType;

@XmlAccessorType(XmlAccessType.FIELD)
public class DeviceInputDto {
    @XmlElement(name = "brand")
    @NotNull
    @Length(min = 2, max = 20)
    private String brand;

    @XmlElement(name = "device_type")
    private DevicyType device;

    @XmlElement(name = "model")
    @NotNull
    @Length(min = 1, max = 20)
    private String model;

    @XmlElement(name = "price")
    @Positive
    private double price;

    @XmlElement(name = "storage")
    @Positive
    private int storage;

    @XmlElement(name = "sale_id")
    private Long saleId;

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public DevicyType getDevice() {
        return device;
    }

    public void setDevice(DevicyType device) {
        this.device = device;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getStorage() {
        return storage;
    }

    public void setStorage(int storage) {
        this.storage = storage;
    }

    public Long getSaleId() {
        return saleId;
    }

    public void setSaleId(Long saleId) {
        this.saleId = saleId;
    }
}
