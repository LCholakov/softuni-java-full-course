package softuni.exam.service.impl;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.entities.Car;
import softuni.exam.models.dto.DealerInputDto;
import softuni.exam.models.dto.DealersImportDto;
import softuni.exam.entities.Dealer; // Add this import
import softuni.exam.repositories.DealerRepository;
import softuni.exam.service.CarService;
import softuni.exam.service.DealerService;
import softuni.exam.util.ValidationUtil;
import softuni.exam.util.XmlParser;

import java.io.IOException;
import java.io.StringReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class DealerServiceImpl implements DealerService {
    private final DealerRepository repository;
    private final CarService carService;
    private final ValidationUtil validator;
//    private final JAXBContext jaxbContext;
    private final ModelMapper modelMapper;
    private final XmlParser xmlParser;


    public DealerServiceImpl(DealerRepository dealerRepository, CarService carService, ValidationUtil validator, ModelMapper modelMapper, XmlParser xmlParser) {
        this.repository = dealerRepository;
        this.carService = carService;
        this.validator = validator;
//        this.jaxbContext = jaxbContext;
        this.modelMapper = modelMapper;
        this.xmlParser = xmlParser;
    }

    @Override
    public boolean areImported() {
        return repository.count() > 0;
    }

    @Override
    public String readDealersFromFile() throws IOException {
        Path path = Paths.get("src/main/resources/files/xml/dealers.xml");
        return Files.readString(path);
    }

    @Override
    public String importDealers() throws IOException, JAXBException {
        DealersImportDto importDto = xmlParser.fromFile(readDealersFromFile(), DealersImportDto.class);

        StringBuilder sb = new StringBuilder();
        for (DealerInputDto dealerInputDto : importDto.getInput()) {
            Dealer dealer = create(dealerInputDto);
            if (dealer == null) {
                sb.append(String.format("Invalid dealer%n"));
            } else {
                sb.append(String.format("Successfully imported dealer %s %s%n", dealer.getFirstName(), dealer.getLastName()));

            }
        }
        return sb.toString();
    }

    private Dealer create(DealerInputDto inputDto) {
        if(!validator.isValid(inputDto)) {
            return null; // or throw an exception based on your validation strategy
        }
        try {
            if (repository.existsByFirstNameAndLastName(
                    inputDto.getFirstName(),
                    inputDto.getLastName())) {
                return null; // Or return existing dealer
            }

            Dealer dealer = modelMapper.map(inputDto, Dealer.class);

            Long carId = inputDto.getOfferingCar().getId();
            if (carId != null) {
                Car car = carService.getReferenceById(carId);
                if (car == null) {
                    return null; // or throw an exception if the car is not found
                }
                dealer.setOfferingCarId(car);
            }
            return repository.save(dealer);
        } catch (Exception e) {
            return null; // or handle the exception as needed
        }
    }
}
