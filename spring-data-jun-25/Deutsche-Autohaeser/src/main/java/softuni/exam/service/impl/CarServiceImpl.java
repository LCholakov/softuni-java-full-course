package softuni.exam.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.entities.Car;
import softuni.exam.entities.Dealership;
import softuni.exam.models.dto.CarInputDto;
import softuni.exam.models.dto.CarInputDto;
import softuni.exam.models.entity.CarType;
import softuni.exam.repositories.CarRepository;
import softuni.exam.service.CarService;
import softuni.exam.service.DealershipService;
import softuni.exam.util.ValidationUtil;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Service
public class CarServiceImpl implements CarService {
    private final CarRepository repository;
    private final Gson gson;
    private final ValidationUtil validator;
    private final ModelMapper modelMapper;
    private final DealershipService dealershipService;


    public CarServiceImpl(CarRepository carRepository, Gson gson, ValidationUtil validator, ModelMapper modelMapper, DealershipService dealershipService) {
        this.repository = carRepository;
        this.gson = gson;
        this.validator = validator;
        this.modelMapper = modelMapper;
        this.dealershipService = dealershipService;
    }

    @Override
    public boolean areImported() {
        return repository.count() > 0;
    }

    @Override
    public String readCarsFileContent() throws IOException {
        Path path = Paths.get("src/main/resources/files/json/cars.json");
        return Files.readString(path);
    }

    @Override
    public String importCars() throws IOException {
        CarInputDto[] carInputDtos = gson.fromJson(readCarsFileContent(), CarInputDto[].class);
        StringBuilder sb = new StringBuilder();

        for (CarInputDto carInputDto : carInputDtos) {
            Car car = create(carInputDto);
            if (car == null) {
                sb.append(String.format("Invalid car%n"));
            } else {
                sb.append(String.format("Successfully imported car %s - %d km.%n", car.getBrand(), car.getMileage()));
            }
        }



        return sb.toString();
    }

    private Car create(CarInputDto carInputDto) {
        if (!validator.isValid(carInputDto)) {
            return null;
        }

        try {
            Car car = modelMapper.map(carInputDto, Car.class);

            Long dealershipId = carInputDto.getDealership();
            if (dealershipId != null) {
                Dealership dealership = dealershipService.getReferenceById(dealershipId);
                car.setDealershipId(dealership);
                repository.save(car);
            }

            return car;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public String exportCars() {
        List<Car> cars = repository.findExportable(CarType.COMBI, 100000);

        StringBuilder sb = new StringBuilder();

        for (Car car : cars) {
            sb.append(String.format("Brand: %s%n", car.getBrand()));
            sb.append(String.format("   *Mileage: %d km.%n", car.getMileage()));
            sb.append(String.format("  **Model: %s%n", car.getModel()));
        }
        return sb.toString();
    }

    @Override
    public Car getReferenceById(Long id) {
        return repository.getReferenceById(id);
    }

}
