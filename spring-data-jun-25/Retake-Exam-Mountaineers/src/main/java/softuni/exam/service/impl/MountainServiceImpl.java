package softuni.exam.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.MountainInputDto;
import softuni.exam.models.entity.Mountain;
import softuni.exam.repository.MountainRepository;
import softuni.exam.service.CountryService;
import softuni.exam.service.MountainService;
import softuni.exam.util.ValidationUtil;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@Service
public class MountainServiceImpl implements MountainService {

    private final MountainRepository mountainRepository;
    private final Gson gson;
    private final ValidationUtil validator;
    private final ModelMapper modelMapper;
    private final CountryService countryService;


    public MountainServiceImpl(MountainRepository mountainRepository, Gson gson, ValidationUtil validator, ModelMapper modelMapper, CountryService countryService) {
        this.mountainRepository = mountainRepository;
        this.gson = gson;
        this.validator = validator;
        this.modelMapper = modelMapper;
        this.countryService = countryService;
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
        MountainInputDto[] mountainInputDtos = gson.fromJson(readMountainsFileContent(), MountainInputDto[].class);
        StringBuilder sb = new StringBuilder();

        for (MountainInputDto mountainInputDto : mountainInputDtos) {
            Mountain mountain = create(mountainInputDto);
            if (mountain == null) {
                sb.append(String.format("Invalid mountain%n"));
            } else {
                sb.append(String.format("Successfully imported mountain %s%n",
                        mountain.getName(), mountain.getName()));
            }
        }
        return sb.toString();
    }

    private Mountain create(MountainInputDto inputDto) {
        if (!validator.isValid(inputDto)) {
            return null;
        }
        try {
            Mountain mountain = modelMapper.map(inputDto, Mountain.class);
            mountainRepository.save(mountain);
            return mountain;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public String exportMountains() {
        return "";
    }
}
