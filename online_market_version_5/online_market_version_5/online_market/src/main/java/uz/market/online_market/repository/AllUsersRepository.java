package uz.market.online_market.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.market.online_market.entity.AllUsers;

@Repository
public interface AllUsersRepository extends JpaRepository<AllUsers, Long> {

}
