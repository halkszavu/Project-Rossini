package ppkeitkhalkszavu.projectrossini.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import ppkeitkhalkszavu.projectrossini.domain.Benefit;
import ppkeitkhalkszavu.projectrossini.domain.Material;
import ppkeitkhalkszavu.projectrossini.domain.UnitOfMeasure;

import java.util.NoSuchElementException;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class CustomMaterialRepositoryImplementation implements CustomMaterialRepository {

    @PersistenceContext
    private EntityManager entityManager;
    private final BenefitRepository benefitRepository;

    @Transactional
    @Override
    public Material save(String name, UnitOfMeasure unit) {
        Material material = new Material();
        material.setName(name);
        material.setUnit(unit);
        entityManager.persist(material);
        return material;
    }

    @Transactional
    @Override
    public Material setBenefit(int id, int benefitId) {
        Optional<Benefit> benefit = benefitRepository.findById(benefitId);
        if (benefit.isEmpty())
            throw new NoSuchElementException("Benefit with id " + benefitId + " not found");
        else{
            Optional<Material> material = entityManager.createQuery("SELECT m FROM Material m WHERE m.id = :id", Material.class)
                    .getResultStream()
                    .findFirst();
            if(material.isEmpty())
                throw new NoSuchElementException("Material with id " + id + " not found");
            else{
                material.get().getBenefit().add(benefit.get());
                entityManager.persist(material.get());
                return material.get();
            }
        }
    }
}
