package org.ankarajug.testinfected.service;

import org.ankarajug.testinfected.domain.CalculationResult;

import java.util.Collection;
import java.util.List;

/**
 * User: mertcaliskan
 * Date: 2/8/13
 */
public interface CalculatorService {

    CalculationResult add(Integer a, Integer b);

    CalculationResult subtract(Integer a, Integer b);

    CalculationResult multiply(Integer a, Integer b);

    CalculationResult divide(Integer a, Integer b);

    List<CalculationResult> getAll();
}