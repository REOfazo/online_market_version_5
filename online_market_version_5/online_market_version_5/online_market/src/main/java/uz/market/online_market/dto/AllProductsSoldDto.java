package uz.market.online_market.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uz.market.online_market.entity.AllProducts;
import uz.market.online_market.entity.AllUsers;

@NoArgsConstructor
@AllArgsConstructor
@Data

public class AllProductsSoldDto {

    private AllUsers allUsers;

    private AllProducts allProducts;

    private double sotilganNarxi;

    private String sotilishUsuli;
}
