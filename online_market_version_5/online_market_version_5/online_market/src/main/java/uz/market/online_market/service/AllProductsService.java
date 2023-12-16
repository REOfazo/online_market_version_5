package uz.market.online_market.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.market.online_market.dto.AllProductsDto;
import uz.market.online_market.entity.AllProducts;
import uz.market.online_market.repository.AllProductsRepository;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class AllProductsService {
    private final AllProductsRepository allProductsRepository;

    @Autowired
    public AllProductsService(AllProductsRepository allProductsRepository) {
        this.allProductsRepository = allProductsRepository;
    }

    public List<AllProducts> getAllProducts() {
        return allProductsRepository.findAll();
    }
    public AllProducts getOneProducts(Long id) {
        return allProductsRepository.findById(id).get();
    }

    public void create(AllProductsDto allProductsDto) {
        AllProducts allProducts = new AllProducts();
        allProducts.setProductColor(allProductsDto.getProductColor());
        allProducts.setProductName(allProductsDto.getProductName());
        allProducts.setProductType(allProductsDto.getProductType());
        allProducts.setBuyPrice(allProductsDto.getBuyPrice());
        allProducts.setMahsulotMiqdori(allProductsDto.getMahsulotMiqdori());
        allProducts.setWarrantyYear(allProductsDto.getWarrantyYear());
        allProducts.setUpdateProductDate(LocalDateTime.now());
        allProductsRepository.save(allProducts);
    }

    public void update(Long id, AllProductsDto allProductsDto) {
        AllProducts allProducts = new AllProducts();
        allProducts.setId(id);
        allProducts.setProductColor(allProductsDto.getProductColor());
        allProducts.setProductName(allProductsDto.getProductName());
        allProducts.setProductType(allProductsDto.getProductType());
        allProducts.setBuyPrice(allProductsDto.getBuyPrice());
        allProducts.setMahsulotMiqdori(allProductsDto.getMahsulotMiqdori());
        allProducts.setWarrantyYear(allProductsDto.getWarrantyYear());
        allProducts.setUpdateProductDate(LocalDateTime.now());
        allProductsRepository.save(allProducts);
    }

    public void deleteAllProduct() {
        allProductsRepository.deleteAll();
    }

    public void deleteOneProduct(Long id) {
        allProductsRepository.deleteById(id);
    }
}
