package sofuni.exam.service.Impl;

import org.springframework.stereotype.Service;
import sofuni.exam.repository.PlanetRepository;
import sofuni.exam.service.PlanetService;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@Service
public class PlanetServiceImpl implements PlanetService {


    private final PlanetRepository planetRepository;

    public PlanetServiceImpl(PlanetRepository planetRepository) {
        this.planetRepository = planetRepository;
    }

    @Override
    public boolean areImported() {
        return planetRepository.count() > 0;
    }

    @Override
    public String readPlanetsFileContent() throws IOException {
        return Files.readString(Path.of("src/main/resources/files/json/planets.json"));
    }

    @Override
    public String importPlanets() throws IOException {
        return null;
    }
}
