package softuni.exam.models.dto;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.util.List;

@XmlRootElement(name = "mountaineers")
@XmlAccessorType(XmlAccessType.FIELD)
public class MountaineersImportDto {
    @XmlElement(name = "mountaineer")
    private List<MountaineerInputDto> mountaineers;

    public List<MountaineerInputDto> getMountaineers() {
        return mountaineers;
    }

    public void setMountaineers(List<MountaineerInputDto> mountaineers) {
        this.mountaineers = mountaineers;
    }
}
