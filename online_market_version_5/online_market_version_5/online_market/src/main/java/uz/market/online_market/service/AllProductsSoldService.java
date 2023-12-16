package uz.market.online_market.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.market.online_market.dto.AllProductsSoldDto;
import uz.market.online_market.entity.AllProductsSold;
import uz.market.online_market.repository.AllProductsSoldRepository;

import java.util.List;

@Service
public class AllProductsSoldService {
    private final AllProductsSoldRepository allProductsSoldRepository;

    @Autowired
    public AllProductsSoldService(AllProductsSoldRepository allProductsSoldRepository) {
        this.allProductsSoldRepository = allProductsSoldRepository;
    }

    public List<AllProductsSold> getAllProductsSold() {
        return allProductsSoldRepository.findAll();
    }

    public AllProductsSold getOneProductsSold(Long id) {
        return allProductsSoldRepository.findById(id).get();
    }

    public void save(AllProductsSoldDto allProductsSoldDto) {
        AllProductsSold allProductsSold = new AllProductsSold();
        allProductsSold.setAllProducts(allProductsSoldDto.getAllProducts());
        allProductsSold.setAllUsers(allProductsSoldDto.getAllUsers());
        allProductsSold.setSotilganNarxi(allProductsSoldDto.getSotilganNarxi());
        allProductsSold.setSotilishUsuli(allProductsSold.getSotilishUsuli());
        allProductsSold.setUpdateProductSoldDate(allProductsSold.getUpdateProductSoldDate());
        allProductsSoldRepository.save(allProductsSold);
    }

    public void update(Long id, AllProductsSoldDto allProductsSoldDto) {
        AllProductsSold allProductsSold = new AllProductsSold();
        allProductsSold.setId(id);
        allProductsSold.setAllProducts(allProductsSoldDto.getAllProducts());
        allProductsSold.setAllUsers(allProductsSoldDto.getAllUsers());
        allProductsSold.setSotilganNarxi(allProductsSoldDto.getSotilganNarxi());
        allProductsSold.setSotilishUsuli(allProductsSold.getSotilishUsuli());
        allProductsSold.setUpdateProductSoldDate(allProductsSold.getUpdateProductSoldDate());
        allProductsSoldRepository.save(allProductsSold);
    }

    public void deleteAllProductsSold() {
        allProductsSoldRepository.deleteAll();
    }

    public void deleteOneProductsSold(Long id) {
        allProductsSoldRepository.deleteById(id);
    }
}
