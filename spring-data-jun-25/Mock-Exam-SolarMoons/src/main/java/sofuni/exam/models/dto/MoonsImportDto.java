package sofuni.exam.models.dto;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.util.List;

@XmlRootElement(name = "moons")
@XmlAccessorType(XmlAccessType.FIELD)
public class MoonsImportDto {
    @XmlElement(name = "moon")
    private List<MoonInputDto> input;

    public List<MoonInputDto> getInput() {
        return input;
    }

    public void setInput(List<MoonInputDto> input) {
        this.input = input;
    }
}
