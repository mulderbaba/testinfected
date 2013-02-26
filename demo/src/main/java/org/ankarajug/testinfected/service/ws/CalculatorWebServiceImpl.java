package org.ankarajug.testinfected.service.ws;

import org.ankarajug.testinfected.domain.CalculationResult;
import org.ankarajug.testinfected.service.CalculatorService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * User: mertcaliskan
 * Date: 2/9/13
 */
public class CalculatorWebServiceImpl implements CalculatorWebService {

    @Autowired
    private CalculatorService service;

    @Override
    public CalculationResult add(Integer a, Integer b) {
        return service.add(a, b);
    }

    @Override
    public CalculationResult subtract(Integer a, Integer b) {
        return service.subtract(a, b);
    }

    @Override
    public CalculationResult multiply(Integer a, Integer b) {
        return service.multiply(a, b);
    }

    @Override
    public CalculationResult divide(Integer a, Integer b) {
        return service.divide(a, b);
    }
}