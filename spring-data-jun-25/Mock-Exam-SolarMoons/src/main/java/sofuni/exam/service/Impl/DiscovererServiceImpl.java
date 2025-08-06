package sofuni.exam.service.Impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import sofuni.exam.models.dto.DiscovererInputDto;
import sofuni.exam.models.entity.Discoverer;
import sofuni.exam.repository.DiscovererRepository;
import sofuni.exam.service.DiscovererService;
import sofuni.exam.util.ValidationUtil;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@Service
public class DiscovererServiceImpl implements DiscovererService {
    
    private final DiscovererRepository discovererRepository;
    private final Gson gson;
    private final ValidationUtil validator;
    private final ModelMapper modelMapper;


    public DiscovererServiceImpl(DiscovererRepository discovererRepository, Gson gson, ValidationUtil validator, ModelMapper modelMapper) {
        this.discovererRepository = discovererRepository;
        this.gson = gson;
        this.validator = validator;
        this.modelMapper = modelMapper;
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
        DiscovererInputDto[] discovererInputDtos = gson.fromJson(readDiscovererFileContent(), DiscovererInputDto[].class);
        StringBuilder sb = new StringBuilder();

        for (DiscovererInputDto discovererInputDto : discovererInputDtos) {
            Discoverer discoverer = create(discovererInputDto);
            if (discoverer == null) {
                sb.append(String.format("Invalid discoverer%n"));
            } else {
                sb.append(String.format("Successfully imported discoverer %s %s%n",
                        discoverer.getFirstName(), discoverer.getLastName()));
            }
        }
        return sb.toString();
    }

    @Override
    public Discoverer getReferenceById(Long id) {
        return discovererRepository.getOne(id);
    }

    private Discoverer create(DiscovererInputDto inputDto) {
        if (!validator.isValid(inputDto)) {
            return null;
        }
        if (discovererRepository.existsByFirstNameAndLastName(
                inputDto.getFirstName(),
                inputDto.getLastName())) {
            return null; // Or return existing dealer
        }
        try {
            Discoverer discoverer = modelMapper.map(inputDto, Discoverer.class);
            discovererRepository.save(discoverer);
            return discoverer;
        } catch (Exception e) {
            return null;
        }
    }
}
