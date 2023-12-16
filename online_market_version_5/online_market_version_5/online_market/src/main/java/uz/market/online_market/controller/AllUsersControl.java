package uz.market.online_market.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import uz.market.online_market.dto.AllUsersDto;
import uz.market.online_market.entity.AllUsers;
import uz.market.online_market.response.ApiResponse;
import uz.market.online_market.role.Role;
import uz.market.online_market.service.AllUsersService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class AllUsersControl {

    private final AllUsersService allUsersService;

    @Autowired
    public AllUsersControl(AllUsersService allUsersService) {
        this.allUsersService = allUsersService;
    }

    @GetMapping("/getallusers")
    @PreAuthorize("hasAnyRole('ADMIN', 'SUPERADMIN')")
    public ResponseEntity<List<AllUsers>> getAllUsers() {
        List<AllUsers> allUsers = allUsersService.getAllUsers();
        return ResponseEntity.ok(allUsers);
    }
    @GetMapping("/getoneuser/{id}")
    @PreAuthorize("hasAnyRole('ADMIN', 'SUPERADMIN', 'USER')")
    public Optional<AllUsers> getOneUser(@PathVariable Long id) {
        return allUsersService.getOneUser(id);
    }
    @PostMapping("/createuser")
    @PreAuthorize("hasAnyRole('ADMIN', 'SUPERADMIN')")
    public ResponseEntity<ApiResponse> createUser(@RequestParam(value = "firstName") String firstName, @RequestParam(value = "lastName") String lastName, @RequestParam(value = "phoneNumber") String phoneNumber,
                                                  @RequestParam(value = "eMail") String eMail, @RequestParam(value = "passportSeries") String passportSeries, @RequestParam(value = "userName") String userName,
                                                  @RequestParam(value = "userPassword") String userPassword, @RequestParam(value = "region") String region, @RequestParam(value = "role") Role role) {
        AllUsersDto allUsers = new AllUsersDto();
        allUsers.setFirstName(firstName);
        allUsers.setLastName(lastName);
        allUsers.setPhoneNumber(phoneNumber);
        allUsers.setEMail(eMail);
        allUsers.setPassportSeries(passportSeries);
        allUsers.setUserName(userName);
        allUsers.setUserPassword(userPassword);
        allUsers.setRegion(region);
        allUsers.setRole(role);

        return ResponseEntity.ok(allUsersService.createUser(allUsers));
    }
    @PutMapping("/updateuser/{id}")
    @PreAuthorize("hasAnyRole('ADMIN', 'SUPERADMIN')")
    public ResponseEntity<ApiResponse> updateUser(@PathVariable Long id, @RequestParam(value = "firstName") String firstName, @RequestParam(value = "lastName") String lastName, @RequestParam(value = "phoneNumber") String phoneNumber,
                                                  @RequestParam(value = "eMail") String eMail, @RequestParam(value = "passportSeries") String passportSeries, @RequestParam(value = "userName") String userName,
                                                  @RequestParam(value = "userPassword") String userPassword, @RequestParam(value = "region") String region, @RequestParam(value = "role") Role role) {
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
        return ResponseEntity.ok(allUsersService.updateUser(id, allUsers));
    }
    @DeleteMapping("/deleteallusers")
    @PreAuthorize("hasAnyRole('SUPERADMIN')")
    public ResponseEntity<ApiResponse> deleteAllUsers() {
        return ResponseEntity.ok(allUsersService.deleteAllUsers());
    }
    @DeleteMapping("/deleteoneuser/{id}")
    @PreAuthorize("hasAnyRole('SUPERADMIN')")
    public ResponseEntity<ApiResponse> deleteOneUSer(@PathVariable Long id) {
        return ResponseEntity.ok(allUsersService.deleteOneUser(id));
    }
}
