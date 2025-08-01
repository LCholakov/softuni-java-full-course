package softuni.exam.dtos;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.util.List;

@XmlRootElement(name = "devices")
@XmlAccessorType(XmlAccessType.FIELD)
public class DevicesImportDto {
    @XmlElement(name = "device")
    private List<DeviceInputDto> devices;

    public List<DeviceInputDto> getDevices() {
        return devices;
    }

    public void setDevices(List<DeviceInputDto> devices) {
        this.devices = devices;
    }
}
