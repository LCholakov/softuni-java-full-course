package softuni.exam.dtos;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import org.hibernate.validator.constraints.Length;
import softuni.exam.enums.DeviceType;

@XmlAccessorType(XmlAccessType.FIELD)
public class DeviceInputDto {
    @XmlElement(name = "brand")
    @NotNull
    @Length(min = 2, max = 20)
    private String brand;

    @XmlElement(name = "device_type")
    private DeviceType device;

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
    private Long sale;

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public DeviceType getDevice() {
        return device;
    }

    public void setDevice(DeviceType device) {
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

    public Long getSale() {
        return sale;
    }

    public void setSale(Long sale) {
        this.sale = sale;
    }
}
