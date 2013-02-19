package org.ankarajug.testinfected.dao;

import org.ankarajug.testinfected.domain.CalculationResult;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

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
}
