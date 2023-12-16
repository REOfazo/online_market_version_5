package uz.market.online_market.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uz.market.online_market.role.Role;

@NoArgsConstructor
@AllArgsConstructor
@Data

public class AllUsersDto {

    private String firstName;

    private String lastName;

    private String phoneNumber;

    private String eMail;

    private String passportSeries;

    private String userName;

    private String userPassword;

    private String region;

    private Role role;
}
