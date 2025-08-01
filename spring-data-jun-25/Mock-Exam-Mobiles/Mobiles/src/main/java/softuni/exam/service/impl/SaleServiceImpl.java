package softuni.exam.service.impl;

import org.springframework.stereotype.Service;
import softuni.exam.repository.SaleRepository;
import softuni.exam.service.SaleService;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@Service
public class SaleServiceImpl implements SaleService {

    private final SaleRepository saleRepository;

    public SaleServiceImpl(SaleRepository saleRepository) {
        this.saleRepository = saleRepository;
    }

    @Override
    public boolean areImported() {
        return saleRepository.count() > 0;
    }

    @Override
    public String readSalesFileContent() throws IOException {
        Path path = Path.of("src/main/resources/files/json/sales.json");
        return Files.readString(path);
    }

    @Override
    public String importSales() throws IOException {
        return "";
    }
}
