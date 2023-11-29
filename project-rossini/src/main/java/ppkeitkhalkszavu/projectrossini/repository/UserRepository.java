package ppkeitkhalkszavu.projectrossini.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ppkeitkhalkszavu.projectrossini.domain.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findById(int id);
}
