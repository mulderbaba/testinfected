package org.ankarajug.testinfected.service.ws;

import org.ankarajug.testinfected.domain.CalculationResult;
import org.ankarajug.testinfected.service.CalculatorService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.jws.WebParam;

/**
 * User: mertcaliskan
 * Date: 2/9/13
 */
public class CalculatorWebServiceImpl implements CalculatorWebService {

    @Autowired
    private CalculatorService service;

    @Override
    public CalculationResult add(double a, double b) {
        return service.add(a, b);
    }

    @Override
    public CalculationResult substract(double a, double b) {
        return service.substract(a, b);
    }

    @Override
    public CalculationResult multiply(double a, double b) {
        return service.multiply(a, b);
    }

    @Override
    public CalculationResult divide(double a, double b) {
        return service.divide(a, b);
    }
}