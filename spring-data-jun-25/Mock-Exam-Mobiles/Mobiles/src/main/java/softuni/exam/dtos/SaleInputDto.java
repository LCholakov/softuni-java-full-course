package softuni.exam.dtos;

import com.google.gson.annotations.Expose;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import softuni.exam.entities.Seller;

import java.time.LocalDateTime;

public class SaleInputDto {
    @Expose
    private Boolean discounted;

    @Expose
    @Length (min = 7, max = 7)
    @NotNull
    private String number;

    @Expose
    @NotNull
    private String saleDate; // leave modelMapper map it to LocalDateTime

    @Expose
    private Long seller;

    public Boolean getDiscounted() {
        return discounted;
    }

    public void setDiscounted(Boolean discounted) {
        this.discounted = discounted;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getSaleDate() {
        return saleDate;
    }

    public void setSaleDate(String saleDate) {
        this.saleDate = saleDate;
    }

    public Long getSeller() {
        return seller;
    }

    public void setSeller(Long seller) {
        this.seller = seller;
    }
}
