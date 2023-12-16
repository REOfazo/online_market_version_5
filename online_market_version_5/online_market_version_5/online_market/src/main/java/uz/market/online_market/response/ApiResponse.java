package uz.market.online_market.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data

public class ApiResponse {
    private String message;
    private boolean status;
}
