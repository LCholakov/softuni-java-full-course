package softuni.exam.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.entities.Dealership;
import softuni.exam.models.dto.DealershipInputDto;
import softuni.exam.repositories.DealershipRepository;
import softuni.exam.service.DealershipService;
import softuni.exam.util.ValidationUtil;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class DealershipServiceImpl implements DealershipService {
    private final DealershipRepository repository;
    private final Gson gson;
    private final ValidationUtil validator;
    private final ModelMapper modelMapper;

    public DealershipServiceImpl(DealershipRepository dealershipRepository, Gson gson, ValidationUtil validator, ModelMapper modelMapper) {
        this.repository = dealershipRepository;
        this.gson = gson;
        this.validator = validator;
        this.modelMapper = modelMapper;
    }

    @Override
    public boolean areImported() {
        return repository.count() > 0;
    }

    @Override
    public String readDealershipsFromFile() throws IOException {
        Path path = Paths.get("src/main/resources/files/json/dealerships.json");
        return Files.readString(path);
    }

    @Override
    public String importDealerships() throws IOException {
        DealershipInputDto[] dealershipInputDtos = gson.fromJson(readDealershipsFromFile(), DealershipInputDto[].class);
        StringBuilder sb = new StringBuilder();

        for (DealershipInputDto dealershipInputDto : dealershipInputDtos) {
            Dealership dealership = create(dealershipInputDto);
            if (dealership == null) {
                sb.append(String.format("Invalid dealership%n"));
            } else {
                sb.append(String.format("Successfully imported dealership %s%n", dealership.getName()));
            }
        }



        return sb.toString();
    }

    @Override
    public Dealership getReferenceById(Long id) {
        return repository.getReferenceById(id);
    }

    private Dealership create(DealershipInputDto dealershipInputDto) {
        if (!validator.isValid(dealershipInputDto)) {
            return null;
        }

        try {
            Dealership dealership = modelMapper.map(dealershipInputDto, Dealership.class);
            repository.save(dealership);
            return dealership;
        } catch (Exception e) {
            return null;
        }
    }
}
