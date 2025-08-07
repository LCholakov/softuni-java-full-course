package softuni.exam.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.CountryInputDto;
import softuni.exam.models.entity.Country;
import softuni.exam.repository.CountryRepository;
import softuni.exam.service.CountryService;
import softuni.exam.util.ValidationUtil;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@Service
public class CountryServiceImpl implements CountryService {

    private final CountryRepository countryRepository;
    private final Gson gson;
    private final ValidationUtil validator;
    private final ModelMapper modelMapper;


    public CountryServiceImpl(CountryRepository countryRepository, Gson gson, ValidationUtil validator, ModelMapper modelMapper) {
        this.countryRepository = countryRepository;
        this.gson = gson;
        this.validator = validator;
        this.modelMapper = modelMapper;
    }

    @Override
    public boolean areImported() {
        return countryRepository.count() > 0;
    }

    @Override
    public String readCountriesFromFile() throws IOException {
        return Files.readString(Path.of("src/main/resources/files/json/countries.json"));
    }

    @Override
    public String importCountries() throws IOException {
        CountryInputDto[] countryInputDtos = gson.fromJson(readCountriesFromFile(), CountryInputDto[].class);
        StringBuilder sb = new StringBuilder();

        for (CountryInputDto countryInputDto : countryInputDtos) {
            Country country = create(countryInputDto);
            if (country == null) {
                sb.append(String.format("Invalid country%n"));
            } else {
                sb.append(String.format("Successfully imported country %s - %s%n",
                        country.getName(), country.getCapital()));
            }
        }
        return sb.toString();
    }

    private Country create(CountryInputDto inputDto) {
        if (!validator.isValid(inputDto)) {
            return null;
        }
        try {
            Country country = modelMapper.map(inputDto, Country.class);
            countryRepository.save(country);
            return country;
        } catch (Exception e) {
            return null;
        }
    }
}
