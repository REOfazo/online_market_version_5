package uz.market.online_market.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.market.online_market.dto.AllUsersDto;
import uz.market.online_market.entity.AllUsers;
import uz.market.online_market.repository.AllUsersRepository;
import uz.market.online_market.response.ApiResponse;

import java.util.List;
import java.util.Optional;

@Service
public class AllUsersService {
    private final AllUsersRepository allUsersRepository;

    @Autowired
    public AllUsersService(AllUsersRepository allUsersRepository) {
        this.allUsersRepository = allUsersRepository;
    }

    public List<AllUsers> getAllUsers() {
        return allUsersRepository.findAll();
    }
    public Optional<AllUsers> getOneUser(Long id) {
        return allUsersRepository.findById(id);
    }
    public ApiResponse createUser(AllUsersDto allUsersDto) {
        AllUsers allUsers = new AllUsers();
        allUsers.setFirstName(allUsersDto.getFirstName());
        allUsers.setLastName(allUsersDto.getLastName());
        allUsers.setUserName(allUsersDto.getUserName());
        allUsers.setUserPassword(allUsersDto.getUserPassword());
        allUsers.setRegion(allUsersDto.getRegion());
        allUsers.setRole(allUsersDto.getRole());
        allUsers.setEMail(allUsersDto.getEMail());
        allUsers.setPhoneNumber(allUsersDto.getPhoneNumber());
        allUsers.setPassportSeries(allUsersDto.getPassportSeries());
        allUsersRepository.save(allUsers);
        return new ApiResponse("User muvaffaqiyatli saqlandi!", true);
    }
    public ApiResponse updateUser(Long id, AllUsers allUsers) {
        AllUsers allUsers1 = allUsersRepository.findById(id).get();
        allUsers1.setUserName(allUsers.getUserName());
        allUsers1.setUserPassword(allUsers.getUserPassword());
        allUsers1.setId(id);
        allUsers1.setRole(allUsers.getRole());
        allUsers1.setRegion(allUsers.getRegion());
        allUsers1.setEMail(allUsers.getEMail());
        allUsers1.setFirstName(allUsers.getFirstName());
        allUsers1.setLastName(allUsers.getLastName());
        allUsers1.setEMail(allUsers.getEMail());
        allUsers1.setPassportSeries(allUsers.getPassportSeries());
        allUsers1.setPhoneNumber(allUsers.getPhoneNumber());
        allUsers1.setUserCreateDate(allUsers1.getUserCreateDate());
        allUsersRepository.save(allUsers1);
        return new ApiResponse(allUsers.getUserName() + " ma'lumotlari muvaffaqiyatli o'zgartirildi!", true);
    }
    public ApiResponse deleteAllUsers() {
        allUsersRepository.deleteAll();
        return new ApiResponse("Barcha userlar o'chirib tashlandi!", true);
    }
    public ApiResponse deleteOneUser(Long id) {
        AllUsers allUsers = allUsersRepository.findById(id).get();
        allUsersRepository.deleteById(id);
        return new ApiResponse(allUsers.getUserName() + " bazadan o'chirib tashlandi!", true);
    }
}
















