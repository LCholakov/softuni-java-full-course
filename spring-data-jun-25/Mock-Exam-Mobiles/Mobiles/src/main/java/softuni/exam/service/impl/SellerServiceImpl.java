package softuni.exam.service.impl;

import org.springframework.stereotype.Service;
import softuni.exam.repository.SellerRepository;
import softuni.exam.service.SellerService;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@Service
public class SellerServiceImpl implements SellerService {
    private final SellerRepository sellerRepository;

    public SellerServiceImpl(SellerRepository sellerRepository) {
        this.sellerRepository = sellerRepository;
    }

    @Override
    public boolean areImported() {
        return sellerRepository.count() > 0;
    }

    @Override
    public String readSellersFromFile() throws IOException {
        Path path = Path.of("src/main/resources/files/json/sellers.json");
        return Files.readString(path);
    }

    @Override
    public String importSellers() throws IOException {
        return "";
    }
}
