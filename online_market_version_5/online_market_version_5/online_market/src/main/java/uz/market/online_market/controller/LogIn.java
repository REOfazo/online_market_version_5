package uz.market.online_market.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.market.online_market.entity.AllUsers;
import uz.market.online_market.response.ApiResponse;
import uz.market.online_market.service.AllUsersService;

import java.util.Iterator;

@RestController
@RequestMapping(value = "/login")

public class LogIn {
    private final AllUsersService allUsersService;

    @Autowired
    public LogIn(AllUsersService allUsersService ) {
        this.allUsersService = allUsersService;
    }

    @GetMapping(value = "/login")
    @PreAuthorize("hasAnyRole('USER', 'ADMIN', 'SUPERADMIN')")
    public ApiResponse logIn(@PathVariable String username, @PathVariable String password) {
        Iterator<AllUsers> iterator = allUsersService.getAllUsers().iterator();
        while (iterator.hasNext()) {
            if (iterator.next().getUserName().equals(username) && iterator.next().getUserPassword().equals(password)) {
                return new ApiResponse("Foydalanuvchi mavjud!", true);
            }
        }
        return new ApiResponse("Foydalanuvchi topilmadi!", false);
    }

}
