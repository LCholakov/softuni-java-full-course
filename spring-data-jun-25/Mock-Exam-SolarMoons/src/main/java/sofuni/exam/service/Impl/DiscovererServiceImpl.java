package sofuni.exam.service.Impl;

import org.springframework.stereotype.Service;
import sofuni.exam.repository.DiscovererRepository;
import sofuni.exam.service.DiscovererService;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@Service
public class DiscovererServiceImpl implements DiscovererService {


    private final DiscovererRepository discovererRepository;

    public DiscovererServiceImpl(DiscovererRepository discovererRepository) {
        this.discovererRepository = discovererRepository;
    }

    @Override
    public boolean areImported() {
        return discovererRepository.count() > 0;
    }

    @Override
    public String readDiscovererFileContent() throws IOException {
        return Files.readString(Path.of("src/main/resources/files/json/discoverers.json"));
    }

    @Override
    public String importDiscoverers() throws IOException {
        return null;
    }
}
