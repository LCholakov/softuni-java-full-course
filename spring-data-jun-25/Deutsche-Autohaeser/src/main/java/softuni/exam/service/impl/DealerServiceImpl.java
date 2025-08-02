package softuni.exam.service.impl;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.DealerInputDto;
import softuni.exam.models.dto.DealersImportDto;
import softuni.exam.entities.Dealer; // Add this import
import softuni.exam.repositories.DealerRepository;
import softuni.exam.service.DealerService;
import softuni.exam.util.ValidationUtil;

import java.io.IOException;
import java.io.StringReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class DealerServiceImpl implements DealerService {
    private final DealerRepository repository;
    private final ValidationUtil validator;
    private final JAXBContext jaxbContext;
    private final ModelMapper modelMapper;


    public DealerServiceImpl(DealerRepository dealerRepository, ValidationUtil validator, JAXBContext jaxbContext, ModelMapper modelMapper) {
        this.repository = dealerRepository;
        this.validator = validator;
        this.jaxbContext = jaxbContext;
        this.modelMapper = modelMapper;
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
        DealersImportDto dealersImportDto = new DealersImportDto();
        String importXml = readDealersFromFile();
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        try (StringReader reader = new StringReader(importXml)) {
            dealersImportDto = (DealersImportDto) unmarshaller.unmarshal(reader);
        }

        StringBuilder sb = new StringBuilder();

        for (DealerInputDto inputDto : dealersImportDto.getInput()) {
            if (!validator.isValid(inputDto)) {
                sb.append("Invalid dealer").append(System.lineSeparator());
                continue;
            }

            var dealer = modelMapper.map(inputDto, Dealer.class);
            repository.save(dealer);
            sb.append(String.format("Successfully imported dealer - %s %s%n", dealer.getFirstName(), dealer.getLastName()));
        }

        return sb.toString();
    }

//    private Dealer create(DealerInputDto inputDto) {
//        System.out.println(inputDto);
//
//        if(!validator.isValid(inputDto)) {
//            return null;
//        }
//
//        try {
//            Dealer device = modelMapper.map(inputDto, Dealer.class);
//
//            Long carId = inputDto.getCarId();
//            if(carId != null) {
//                Car sale = carService.getReferenceById(saleId);
//                int x;
//                device.setSale(sale);
//            }
//
//            deviceRepository.save(device);
//            return device;
//        } catch (Exception e) {
//            return null;
//        }
//    }
}
