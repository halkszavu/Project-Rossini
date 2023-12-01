package ppkeitkhalkszavu.projectrossini.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ppkeitkhalkszavu.projectrossini.domain.Material;

import java.util.Optional;

public interface MaterialRepository extends JpaRepository<Material, Integer> {
    Optional<Material> findByName(String name);
}
