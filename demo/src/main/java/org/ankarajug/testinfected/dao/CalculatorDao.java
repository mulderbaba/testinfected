package org.ankarajug.testinfected.dao;

import org.ankarajug.testinfected.domain.CalculationResult;

import java.util.List;

/**
 * User: mertcaliskan
 * Date: 2/8/13
 */
public interface CalculatorDao {

    void save(CalculationResult result);

    void save(List<CalculationResult> result);

    void delete(CalculationResult result);

    CalculationResult findById(CalculationResult result);

    List<CalculationResult> getAll();
}
