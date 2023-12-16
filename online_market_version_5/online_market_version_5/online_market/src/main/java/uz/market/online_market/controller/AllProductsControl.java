package uz.market.online_market.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import uz.market.online_market.dto.AllProductsDto;
import uz.market.online_market.entity.AllProducts;
import uz.market.online_market.response.ApiResponse;
import uz.market.online_market.service.AllProductsService;

import java.util.List;

@RestController
@RequestMapping("/productscontrol")
public class AllProductsControl {
    private final AllProductsService allProductsService;

    @Autowired
    public AllProductsControl(AllProductsService allProductsService) {
        this.allProductsService = allProductsService;
    }

    @GetMapping("/getallproducts")
    @PreAuthorize("hasAnyRole('ADMIN', 'SUPERADMIN')")
    public ResponseEntity<List<AllProducts>> getAllProducts() {
        return ResponseEntity.ok(allProductsService.getAllProducts());
    }
    @GetMapping("/getoneproducts/{id}")
    @PreAuthorize("hasAnyRole('ADMIN', 'SUPERADMIN')")
    public ResponseEntity<?> getOneProducts(@PathVariable Long id) {
        return ResponseEntity.ok(allProductsService.getOneProducts(id));
    }
    @PostMapping("/createproduct")
    @PreAuthorize("hasAnyRole('ADMIN', 'SUPERADMIN')")
    public ResponseEntity<ApiResponse> createProduct(@RequestParam(value = "productName") String productName, @RequestParam(value = "productType") String productType,
                                                     @RequestParam(value = "productColor") String productColor, @RequestParam(value = "warrantyYear") byte warrantyYear,
                                                     @RequestParam(value = "mahsulotMiqdori") int mahsulotMiqdori, @RequestParam(value = "buyPrice") double buyPrice) {
        AllProductsDto allProductsDto = new AllProductsDto();
        allProductsDto.setProductName(productName);
        allProductsDto.setProductType(productType);
        allProductsDto.setProductColor(productColor);
        allProductsDto.setWarrantyYear(warrantyYear);
        allProductsDto.setMahsulotMiqdori(mahsulotMiqdori);
        allProductsDto.setBuyPrice(buyPrice);
        allProductsService.create(allProductsDto);
        return ResponseEntity.ok(new ApiResponse("Ma'lumot muvaffaqiyatli saqlandi!", true));
    }
    @PutMapping("/updateproduct/{id}")
    @PreAuthorize("hasAnyRole('ADMIN', 'SUPERADMIN')")
    public ResponseEntity<ApiResponse> updateProduct(@PathVariable Long id, @RequestParam(value = "productName") String productName, @RequestParam(value = "productType") String productType,
                                                     @RequestParam(value = "productColor") String productColor, @RequestParam(value = "warrantyYear") byte warrantyYear,
                                                     @RequestParam(value = "mahsulotMiqdori") int mahsulotMiqdori, @RequestParam(value = "buyPrice") double buyPrice) {
        AllProductsDto allProductsDto = new AllProductsDto();
        allProductsDto.setProductName(productName);
        allProductsDto.setProductType(productType);
        allProductsDto.setProductColor(productColor);
        allProductsDto.setWarrantyYear(warrantyYear);
        allProductsDto.setMahsulotMiqdori(mahsulotMiqdori);
        allProductsDto.setBuyPrice(buyPrice);
        allProductsService.create(allProductsDto);
        allProductsService.update(id, allProductsDto);
        return ResponseEntity.ok(new ApiResponse("Ma'lumot muvaffaqiyatli o'zgartirildi!", true));
    }
    @DeleteMapping("/deleteallproduct")
    @PreAuthorize("hasAnyRole('SUPERADMIN')")
    public ResponseEntity<?> deleteAllProduct() {
        allProductsService.deleteAllProduct();
        return ResponseEntity.ok(new ApiResponse("Baza bo'shatildi!", true));
    }
    @DeleteMapping("/deleteoneproduct/{id}")
    @PreAuthorize("hasAnyRole('ADMIN', 'SUPERADMIN')")
    public ResponseEntity<?> deleteOneProduct(Long id) {
        allProductsService.deleteOneProduct(id);
        return ResponseEntity.ok(new ApiResponse(allProductsService.getOneProducts(id).getProductName() + " o'chirib tashlandi!", true));
    }
}
