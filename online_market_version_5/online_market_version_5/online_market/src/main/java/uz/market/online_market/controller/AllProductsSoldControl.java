package uz.market.online_market.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import uz.market.online_market.dto.AllProductsSoldDto;
import uz.market.online_market.entity.AllProducts;
import uz.market.online_market.entity.AllProductsSold;
import uz.market.online_market.entity.AllUsers;
import uz.market.online_market.response.ApiResponse;
import uz.market.online_market.role.Role;
import uz.market.online_market.service.AllProductsSoldService;

import java.util.List;

@RestController
@RequestMapping("/productssoldcontrol")
public class AllProductsSoldControl {
    private final AllProductsSoldService allProductsSoldService;

    @Autowired
    public AllProductsSoldControl(AllProductsSoldService allProductsSoldService) {
        this.allProductsSoldService = allProductsSoldService;
    }

    @GetMapping("/getallproductssold")
    @PreAuthorize("hasAnyRole('USER', 'ADMIN', 'SUPERADMIN')")
    public ResponseEntity<?> getAllProductsSold() {
        List<AllProductsSold> allProductsSold = allProductsSoldService.getAllProductsSold();
        return ResponseEntity.ok(allProductsSold);
    }
    @GetMapping("/getoneproductssold/{id}")
    @PreAuthorize("hasAnyRole('USER', 'ADMIN', 'SUPERADMIN')")
    public ResponseEntity<?> getOneProductsSold(@PathVariable Long id) {
        return ResponseEntity.ok(allProductsSoldService.getOneProductsSold(id));
    }
    @PostMapping("/createproductsold")
    @PreAuthorize("hasAnyRole('USER', 'ADMIN', 'SUPERADMIN')")
    public ResponseEntity<?> createProductsSold(@RequestParam(value = "firstName") String firstName,
                                                @RequestParam(value = "lastName") String lastName,
                                                @RequestParam(value = "phoneNumber") String phoneNumber,
                                                @RequestParam(value = "eMail") String eMail,
                                                @RequestParam(value = "passportSeries") String passportSeries,
                                                @RequestParam(value = "userName") String userName,
                                                @RequestParam(value = "userPassword") String userPassword,
                                                @RequestParam(value = "region") String region,
                                                @RequestParam(value = "role") Role role,
                                                @RequestParam(value = "productName") String productName,
                                                @RequestParam(value = "productType") String productType,
                                                @RequestParam(value = "productColor") String productColor,
                                                @RequestParam(value = "warrantyYear") byte warrantyYear,
                                                @RequestParam(value = "mahsulotMiqdori") int mahsulotMiqdori,
                                                @RequestParam(value = "buyPrice") double buyPrice,
                                                @RequestParam(value = "sotilganNarxi") double sotilganNarxi,
                                                @RequestParam(value = "sotilishUsuli") String sotilishUsuli) {
        AllUsers allUsers = new AllUsers();
        allUsers.setFirstName(firstName);
        allUsers.setLastName(lastName);
        allUsers.setPhoneNumber(phoneNumber);
        allUsers.setEMail(eMail);
        allUsers.setPassportSeries(passportSeries);
        allUsers.setUserName(userName);
        allUsers.setUserPassword(userPassword);
        allUsers.setRegion(region);
        allUsers.setRole(role);

        AllProducts allProducts = new AllProducts();
        allProducts.setProductName(productName);
        allProducts.setProductType(productType);
        allProducts.setProductColor(productColor);
        allProducts.setWarrantyYear(warrantyYear);
        allProducts.setMahsulotMiqdori(mahsulotMiqdori);
        allProducts.setBuyPrice(buyPrice);

        AllProductsSoldDto allProductsSold = new AllProductsSoldDto();
        allProductsSold.setAllUsers(allUsers);
        allProductsSold.setAllProducts(allProducts);
        allProductsSold.setSotilganNarxi(sotilganNarxi);
        allProductsSold.setSotilishUsuli(sotilishUsuli);

        allProductsSoldService.save(allProductsSold);
        return ResponseEntity.ok(new ApiResponse("Ma'lumot muvaffaqiyatli qo'shildi!", true));
    }
    @PutMapping("/updateproductssold/{id}")
    @PreAuthorize("hasAnyRole('USER', 'ADMIN', 'SUPERADMIN')")
    public ResponseEntity<?> updateProductsSold(@PathVariable Long id, @RequestParam(value = "firstName") String firstName,
                                                @RequestParam(value = "lastName") String lastName,
                                                @RequestParam(value = "phoneNumber") String phoneNumber,
                                                @RequestParam(value = "eMail") String eMail,
                                                @RequestParam(value = "passportSeries") String passportSeries,
                                                @RequestParam(value = "userName") String userName,
                                                @RequestParam(value = "userPassword") String userPassword,
                                                @RequestParam(value = "region") String region,
                                                @RequestParam(value = "role") Role role,
                                                @RequestParam(value = "productName") String productName,
                                                @RequestParam(value = "productType") String productType,
                                                @RequestParam(value = "productColor") String productColor,
                                                @RequestParam(value = "warrantyYear") byte warrantyYear,
                                                @RequestParam(value = "mahsulotMiqdori") int mahsulotMiqdori,
                                                @RequestParam(value = "buyPrice") double buyPrice,
                                                @RequestParam(value = "sotilganNarxi") double sotilganNarxi,
                                                @RequestParam(value = "sotilishUsuli") String sotilishUsuli) {
        AllUsers allUsers = new AllUsers();
        allUsers.setFirstName(firstName);
        allUsers.setLastName(lastName);
        allUsers.setPhoneNumber(phoneNumber);
        allUsers.setEMail(eMail);
        allUsers.setPassportSeries(passportSeries);
        allUsers.setUserName(userName);
        allUsers.setUserPassword(userPassword);
        allUsers.setRegion(region);
        allUsers.setRole(role);

        AllProducts allProducts = new AllProducts();
        allProducts.setProductName(productName);
        allProducts.setProductType(productType);
        allProducts.setProductColor(productColor);
        allProducts.setWarrantyYear(warrantyYear);
        allProducts.setMahsulotMiqdori(mahsulotMiqdori);
        allProducts.setBuyPrice(buyPrice);

        AllProductsSoldDto allProductsSold = new AllProductsSoldDto();
        allProductsSold.setAllUsers(allUsers);
        allProductsSold.setAllProducts(allProducts);
        allProductsSold.setSotilganNarxi(sotilganNarxi);
        allProductsSold.setSotilishUsuli(sotilishUsuli);

        allProductsSoldService.update(id, allProductsSold);
        return ResponseEntity.ok(new ApiResponse(allProductsSoldService.getOneProductsSold(id).getAllProducts().getProductName() + "Ma'lumot muvaffaqiyatli o'zgartirildi!", true));
    }
    @DeleteMapping("/deleteallproductssold")
    @PreAuthorize("hasAnyRole('SUPERADMIN')")
    public ResponseEntity<?> deleteAllProductsSold() {
        allProductsSoldService.deleteAllProductsSold();
        return ResponseEntity.ok(new ApiResponse("Baza tozalandi!", true));
    }
    @DeleteMapping("/deleteoneproductssold/{id}")
    @PreAuthorize("hasAnyRole('USER', 'ADMIN', 'SUPERADMIN')")
    public ResponseEntity<?> deleteOneProductsSold(@PathVariable Long id) {
        allProductsSoldService.deleteOneProductsSold(id);
        return ResponseEntity.ok(new ApiResponse(allProductsSoldService.getOneProductsSold(id).getAllProducts().getProductName() + " o'chirib tashlandi!", true));
    }
}
