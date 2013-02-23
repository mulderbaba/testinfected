package org.ankarajug.testinfected.service;

import org.ankarajug.testinfected.domain.CalculationResult;

import java.util.Collection;
import java.util.List;

/**
 * User: mertcaliskan
 * Date: 2/8/13
 */
public interface CalculatorService {

    CalculationResult add(double a, double b);

    CalculationResult subtract(double a, double b);

    CalculationResult multiply(double a, double b);

    CalculationResult divide(double a, double b);

    List<CalculationResult> getAll();
}