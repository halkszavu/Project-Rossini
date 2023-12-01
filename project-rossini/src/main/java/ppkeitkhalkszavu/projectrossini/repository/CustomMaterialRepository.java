package ppkeitkhalkszavu.projectrossini.repository;

import ppkeitkhalkszavu.projectrossini.domain.Material;
import ppkeitkhalkszavu.projectrossini.domain.UnitOfMeasure;

public interface CustomMaterialRepository {
    Material save(String name, UnitOfMeasure unit);
    Material setBenefit(int id, int benefitId);
}
