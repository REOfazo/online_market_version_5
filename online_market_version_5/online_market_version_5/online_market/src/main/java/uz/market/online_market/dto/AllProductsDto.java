package uz.market.online_market.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data

public class AllProductsDto {

    private String productName;

    private String productType;

    private String productColor;

    private byte warrantyYear;

    private int mahsulotMiqdori;

    private double buyPrice;
}
