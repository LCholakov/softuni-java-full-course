package sofuni.exam.service.Impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import sofuni.exam.models.dto.PlanetInputDto;
import sofuni.exam.models.entity.Planet;
import sofuni.exam.repository.PlanetRepository;
import sofuni.exam.service.PlanetService;
import sofuni.exam.util.ValidationUtil;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@Service
public class PlanetServiceImpl implements PlanetService {
    private final PlanetRepository planetRepository;
    private final Gson gson;
    private final ValidationUtil validator;
    private final ModelMapper modelMapper;


    public PlanetServiceImpl(PlanetRepository planetRepository, Gson gson, ValidationUtil validator, ModelMapper modelMapper) {
        this.planetRepository = planetRepository;
        this.gson = gson;
        this.validator = validator;
        this.modelMapper = modelMapper;
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
        PlanetInputDto[] planetInputDtos = gson.fromJson(readPlanetsFileContent(), PlanetInputDto[].class);
        StringBuilder sb = new StringBuilder();

        for (PlanetInputDto planetInputDto : planetInputDtos) {
            Planet planet = create(planetInputDto);
            if (planet == null) {
                sb.append(String.format("Invalid planet%n"));
            } else {
                sb.append(String.format("Successfully imported planet %s%n",
                        planet.getName()));
            }
        }
        return sb.toString();
    }

    @Override
    public Planet getReferenceById(Long id) {
        return planetRepository.getOne(id);
    }

    private Planet create(PlanetInputDto inputDto) {
        if (!validator.isValid(inputDto)) {
            return null;
        }
        try {
            Planet planet = modelMapper.map(inputDto, Planet.class);
            planetRepository.save(planet);
            return planet;
        } catch (Exception e) {
            return null;
        }
    }
}
