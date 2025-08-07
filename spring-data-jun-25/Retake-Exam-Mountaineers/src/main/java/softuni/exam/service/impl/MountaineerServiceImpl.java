package softuni.exam.service.impl;

import jakarta.xml.bind.JAXBException;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.MountaineerInputDto;
import softuni.exam.models.dto.MountaineersImportDto;
import softuni.exam.models.entity.Mountain;
import softuni.exam.models.entity.Mountaineer;
import softuni.exam.repository.MountaineerRepository;
import softuni.exam.service.MountainService;
import softuni.exam.service.MountaineerService;
import softuni.exam.util.ValidationUtil;
import softuni.exam.util.XmlParser;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@Service
public class MountaineerServiceImpl implements MountaineerService {

    private final MountaineerRepository mountaineerRepository;
    private final MountainService mountainService;
    private final ValidationUtil validator;
    private final ModelMapper modelMapper;
    private final XmlParser xmlParser;


    public MountaineerServiceImpl(MountaineerRepository mountaineerRepository, MountainService mountainService, ValidationUtil validator, ModelMapper modelMapper,  XmlParser xmlParser) {
        this.mountaineerRepository = mountaineerRepository;
        this.mountainService = mountainService;
        this.validator = validator;
        this.modelMapper = modelMapper;
        this.xmlParser = xmlParser;
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
        MountaineersImportDto importDto = xmlParser.fromXml(readMountaineersFromFile(), MountaineersImportDto.class);

        StringBuilder sb = new StringBuilder();
        for (MountaineerInputDto mountaineerInputDto : importDto.getMountaineers()) {
            Mountaineer mountaineer = create(mountaineerInputDto);
            if (mountaineer == null) {
                sb.append(String.format("Invalid mountaineer%n"));
            } else {
                sb.append(String.format("Successfully imported mountaineer %s %s%n", mountaineer.getFirstName(), mountaineer.getLastName()));
            }
        }
        return sb.toString();
    }

    private Mountaineer create(MountaineerInputDto inputDto) {
        if(!validator.isValid(inputDto)) {
            return null;
        }
        try {
            if (mountaineerRepository.existsByFirstNameAndLastName(inputDto.getFirstName(), inputDto.getLastName())) {
                return null;
            }

            Mountaineer mountaineer = modelMapper.map(inputDto, Mountaineer.class);

            Long mountainId = inputDto.getClimbingMountain();
            if (mountainId != null) {
                Mountain mountain = mountainService.getReferenceById(mountainId);
                if (mountain == null) {
                    return null;
                }
                mountaineer.setClimbingMountainId(mountain);
            }

            return mountaineerRepository.save(mountaineer);
        } catch (Exception e) {
            return null; // or handle the exception as needed
        }
    }
}
