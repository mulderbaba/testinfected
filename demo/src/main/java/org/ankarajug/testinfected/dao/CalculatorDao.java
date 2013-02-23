package org.ankarajug.testinfected.dao;

import org.ankarajug.testinfected.domain.CalculationResult;

/**
 * User: mertcaliskan
 * Date: 2/8/13
 */
public interface CalculatorDao {

    void save(CalculationResult result);

    CalculationResult findById(CalculationResult result);
}
