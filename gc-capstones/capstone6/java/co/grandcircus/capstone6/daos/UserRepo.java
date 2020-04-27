package co.grandcircus.capstone6.daos;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import co.grandcircus.capstone6.entities.User;

public interface UserRepo extends JpaRepository<User, Long> {

	User findByUsernameIgnoreCase(String username);

	User findUserById(Long id);

	User findUserByUsername(String username);

}
