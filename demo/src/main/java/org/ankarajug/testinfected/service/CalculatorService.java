package org.ankarajug.testinfected.service;

import org.ankarajug.testinfected.domain.CalculationResult;

/**
 * User: mertcaliskan
 * Date: 2/8/13
 */
public interface CalculatorService {

    CalculationResult add(double a, double b);

    CalculationResult substract(double a, double b);

    CalculationResult multiply(double a, double b);

    CalculationResult divide(double a, double b);
}