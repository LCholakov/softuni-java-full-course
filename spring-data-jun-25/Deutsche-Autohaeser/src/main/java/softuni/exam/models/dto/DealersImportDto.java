package softuni.exam.models.dto;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.util.List;

@XmlRootElement(name = "dealers")
@XmlAccessorType(XmlAccessType.FIELD)
public class DealersImportDto {
    @XmlElement(name = "dealer")
    private List<DealerInputDto> input;

    public List<DealerInputDto> getInput() {
        return input;
    }

    public void setInput(List<DealerInputDto> input) {
        this.input = input;
    }
}
