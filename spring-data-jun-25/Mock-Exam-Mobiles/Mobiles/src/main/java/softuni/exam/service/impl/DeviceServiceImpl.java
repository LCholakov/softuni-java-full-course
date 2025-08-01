package softuni.exam.service.impl;

import jakarta.xml.bind.JAXBException;
import org.springframework.stereotype.Service;
import softuni.exam.repository.DeviceRepository;
import softuni.exam.service.DeviceService;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@Service
public class DeviceServiceImpl implements DeviceService {
    private final DeviceRepository deviceRepository;

    public DeviceServiceImpl(DeviceRepository deviceRepository) {
        this.deviceRepository = deviceRepository;
    }

    @Override
    public boolean areImported() {
        return deviceRepository.count() > 0;
    }

    @Override
    public String readDevicesFromFile() throws IOException {
        Path path = Path.of("src/main/resources/files/xml/devices.xml");
        return Files.readString(path);
    }

    @Override
    public String importDevices() throws IOException, JAXBException {
        return "";
    }

    @Override
    public String exportDevices() {
        return "";
    }
}
