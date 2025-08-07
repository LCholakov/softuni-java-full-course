package softuni.exam.service.impl;

import org.springframework.stereotype.Service;
import softuni.exam.repository.MountainRepository;
import softuni.exam.service.MountainService;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@Service
public class MountainServiceImpl implements MountainService {

    private final MountainRepository mountainRepository;

    public MountainServiceImpl(MountainRepository mountainRepository) {
        this.mountainRepository = mountainRepository;
    }

    @Override
    public boolean areImported() {
        return mountainRepository.count() > 0;
    }

    @Override
    public String readMountainsFileContent() throws IOException {
        return Files.readString(Path.of("src/main/resources/files/json/mountains.json"));
    }

    @Override
    public String importMountains() throws IOException {
        return "";
    }

    @Override
    public String exportMountains() {
        return "";
    }
}
