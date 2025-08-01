package softuni.exam.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.dtos.SaleInputDto;
import softuni.exam.entities.Sale;
import softuni.exam.entities.Seller;
import softuni.exam.repository.SaleRepository;
import softuni.exam.service.SaleService;
import softuni.exam.service.SellerService;
import softuni.exam.util.ValidationUtil;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@Service
public class SaleServiceImpl implements SaleService {
    private final SellerService sellerService;
    private final SaleRepository saleRepository;
    private final Gson gson;
    private final ValidationUtil validator;
    private final ModelMapper modelMapper;

    public SaleServiceImpl(SellerService sellerService, SaleRepository saleRepository, Gson gson, ValidationUtil validator, ModelMapper modelMapper) {
        this.sellerService = sellerService;
        this.saleRepository = saleRepository;
        this.gson = gson;
        this.validator = validator;
        this.modelMapper = modelMapper;
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
        SaleInputDto[] saleInputDtos = gson.fromJson(readSalesFileContent(), SaleInputDto[].class);

        StringBuilder sb = new StringBuilder();
        for (SaleInputDto saleInputDto : saleInputDtos) {
            Sale sale = create(saleInputDto);
            if(sale == null) {
                sb.append(String.format("Invalid sale%n"));
            }
            else {
                sb.append(String.format("Successfully imported sale with number %s%n",
                        sale.getNumber()));
            }
            
        }

        return sb.toString();
    }

    @Override
    public Sale getReferenceById(Long id) {
        return saleRepository.getReferenceById(id);
    }

    private Sale create(SaleInputDto saleInputDto) {
        if(!validator.isValid(saleInputDto)) {
            return null;
        }
        try {
            Sale sale = modelMapper.map(saleInputDto, Sale.class);

            // This is key to get the relation between two records
            Long sellerId = saleInputDto.getSeller();
            if(sellerId == null) {
                Seller seller = sellerService.getReferenceById(sellerId);
                sale.setSeller(seller);
            }

            saleRepository.save(sale);
            // we need to set the seller manually, because model mapper won't be able to do this
            // somethins is misssing -> the relation with Seller

            return sale;
        } catch (Exception e) {
            return null;
        }
    }
}
