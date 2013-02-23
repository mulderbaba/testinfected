package org.ankarajug.testinfected.dao;

import org.ankarajug.testinfected.domain.CalculationResult;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * User: mertcaliskan
 * Date: 2/8/13
 */
@Repository
public class CalculatorDaoHibernate implements CalculatorDao {

    @PersistenceContext(unitName = "emf")
    protected EntityManager entityManager;

    @Override
    public void save(CalculationResult result) {
        entityManager.persist(result);
    }

    @Override
    public void save(List<CalculationResult> resultList) {
        for (CalculationResult result : resultList) {
            entityManager.persist(result);
        }
    }

    @Override
    public void delete(CalculationResult result) {
        entityManager.remove(result);
    }

    @Override
    public CalculationResult findById(CalculationResult result) {
        return entityManager.find(CalculationResult.class, result.getId());
    }

    @Override
    public List<CalculationResult> getAll() {
        return entityManager.createQuery("select cr from CalculationResult cr", CalculationResult.class).getResultList();
    }
}
