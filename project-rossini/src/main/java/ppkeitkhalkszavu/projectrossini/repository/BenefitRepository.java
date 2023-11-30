package ppkeitkhalkszavu.projectrossini.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ppkeitkhalkszavu.projectrossini.domain.Benefit;

import java.util.Optional;

public interface BenefitRepository extends JpaRepository<Benefit, Integer> {
    Optional<Benefit> findById(int id);
}
