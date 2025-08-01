package softuni.exam.service.impl;

import com.google.gson.Gson;
import jakarta.validation.Validator;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.dtos.SellerInputDto;
import softuni.exam.entities.Seller;
import softuni.exam.repository.SellerRepository;
import softuni.exam.service.SellerService;
import softuni.exam.util.ValidationUtil;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class SellerServiceImpl implements SellerService {
    private final SellerRepository sellerRepository;
    private final Gson gson;
    private final ValidationUtil validator;
    private final ModelMapper modelMapper;

    public SellerServiceImpl(SellerRepository sellerRepository, Gson gson, ValidationUtil validator, ModelMapper modelMapper) {
        this.sellerRepository = sellerRepository;
        this.gson = gson;
        this.validator = validator;
        this.modelMapper = modelMapper;
    }

    @Override
    public boolean areImported() {
        return sellerRepository.count() > 0;
    }

    @Override
    public String readSellersFromFile() throws IOException {
        Path path = Paths.get("src/main/resources/files/json/sellers.json");

        return Files.readString(path);
    }

    @Override
    public String importSellers() throws IOException {
        // 1. Parse sellers.json -> SellerInputDto[]
        // deserialize the content of the file into an array of SellerInputDto objects
        SellerInputDto[] sellerInputDtos = gson.fromJson(readSellersFromFile(), SellerInputDto[].class);
        // 2. Create a Seller for each SellerInputDto (keep track of success)'

        StringBuilder sb = new StringBuilder();

        for (SellerInputDto sellerInputDto : sellerInputDtos) {
            Seller seller = create(sellerInputDto);
            if (seller == null) {
                sb.append(String.format("Invalid seller%n"));
            } else {
                sb.append(String.format("Successfully imported seller %s %s%n",
                        seller.getFirstName(), seller.getLastName()));
            }
        }
        // 3. Prepare output

        return sb.toString();
    }

    @Override
    public Seller getReferenceById(Long id) {
        return sellerRepository.getReferenceById(id);
    }

    private Seller create(SellerInputDto inputDto) {
        if (!validator.isValid(inputDto)) {
            return null;
        }
        try {
            Seller seller = modelMapper.map(inputDto, Seller.class);
            sellerRepository.save(seller);
            return seller;
        } catch (Exception e) {
            return null;
        }
    }
}
