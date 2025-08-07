package softuni.exam.service.impl;

import jakarta.xml.bind.JAXBException;
import org.springframework.stereotype.Service;
import softuni.exam.repository.MountaineerRepository;
import softuni.exam.service.MountaineerService;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@Service
public class MountaineerServiceImpl implements MountaineerService {

    private final MountaineerRepository mountaineerRepository;

    public MountaineerServiceImpl(MountaineerRepository mountaineerRepository) {
        this.mountaineerRepository = mountaineerRepository;
    }

    @Override
    public boolean areImported() {
        return mountaineerRepository.count() > 0;
    }

    @Override
    public String readMountaineersFromFile() throws IOException {
        return Files.readString(Path.of("src/main/resources/files/xml/mountaineers.xml"));
    }

    @Override
    public String importMountaineers() throws IOException, JAXBException {
        return "";
    }
}
