package sofuni.exam.service.Impl;

import jakarta.xml.bind.JAXBException;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import sofuni.exam.models.dto.MoonInputDto;
import sofuni.exam.models.dto.MoonsImportDto;
import sofuni.exam.models.entity.Discoverer;
import sofuni.exam.models.entity.Moon;
import sofuni.exam.models.entity.Planet;
import sofuni.exam.models.enums.Type;
import sofuni.exam.repository.MoonRepository;
import sofuni.exam.service.DiscovererService;
import sofuni.exam.service.MoonService;
import sofuni.exam.service.PlanetService;
import sofuni.exam.util.ValidationUtil;
import sofuni.exam.util.XmlParser;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

@Service
public class MoonServiceImpl implements MoonService {

    private final MoonRepository moonRepository;
    private final DiscovererService discovererService;
    private final ValidationUtil validator;
    private final ModelMapper modelMapper;
    private final XmlParser xmlParser;
    private final PlanetService planetService;


    public MoonServiceImpl(MoonRepository moonRepository, DiscovererService discovererService, ValidationUtil validator, ModelMapper modelMapper, XmlParser xmlParser, PlanetService planetService) {
        this.moonRepository = moonRepository;
        this.discovererService = discovererService;
        this.validator = validator;
        this.modelMapper = modelMapper;
        this.xmlParser = xmlParser;
        this.planetService = planetService;
    }

    @Override
    public boolean areImported() {
        return moonRepository.count() > 0;
    }

    @Override
    public String readMoonsFileContent() throws IOException {
        return Files.readString(Path.of("src/main/resources/files/xml/moons.xml"));
    }

    @Override
    public String importMoons() throws IOException, JAXBException {
        MoonsImportDto importDto = xmlParser.fromFile(readMoonsFileContent(), MoonsImportDto.class);

        StringBuilder sb = new StringBuilder();
        for (MoonInputDto moonInputDto : importDto.getInput()) {
            Moon moon = create(moonInputDto);
            if (moon == null) {
                sb.append(String.format("Invalid moon%n"));
            } else {
                sb.append(String.format("Successfully imported moon %s%n", moon.getName()));
            }
        }
        return sb.toString();
    }

    private Moon create(MoonInputDto inputDto) {
        if(!validator.isValid(inputDto)) {
            return null;
        }
        try {
            if (moonRepository.existsByName(inputDto.getName())) {
                return null;
            }

            Moon moon = modelMapper.map(inputDto, Moon.class);

            Long planetId = inputDto.getPlanet();
            if (planetId != null) {
                Planet planet = planetService.getReferenceById(planetId);
                if (planet == null) {
                    return null;
                }
                moon.setPlanetId(planet);
            }

            Long discovererId = inputDto.getDiscoverer();
            if (discovererId != null) {
                Discoverer discoverer = discovererService.getReferenceById(discovererId);
                if (discoverer == null) {
                    return null;
                }
                moon.setDiscovererId(discoverer);
            }

            return moonRepository.save(moon);
        } catch (Exception e) {
            return null; // or handle the exception as needed
        }
    }

    @Override
    public String exportMoons() {
        List<Moon> moons = moonRepository.findExportable(Type.GAS_GIANT, 700, 2000);

        StringBuilder sb = new StringBuilder();

        for (Moon moon : moons) {
            sb.append(String.format("***Moon %s is a natural satellite of %s and has a radius of %.2f km.%n",
                    moon.getName(), moon.getPlanetId().getName(), moon.getRadius()));
            sb.append(String.format("****Discovered by %s %s%n%n",
                    moon.getDiscovererId().getFirstName(), moon.getDiscovererId().getLastName()));
        }
        return sb.toString();
    }
}
