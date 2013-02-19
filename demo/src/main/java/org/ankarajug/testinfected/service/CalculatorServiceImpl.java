package org.ankarajug.testinfected.service;

import org.ankarajug.testinfected.dao.CalculatorDao;
import org.ankarajug.testinfected.domain.CalculationResult;
import org.ankarajug.testinfected.domain.builder.Action;
import org.ankarajug.testinfected.domain.builder.CalculationResultBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * User: mertcaliskan
 * Date: 2/8/13
 */
@Service
public class CalculatorServiceImpl implements CalculatorService {

    @Autowired
    private CalculatorDao dao;

    @Override
    @Transactional
    public CalculationResult add(double a, double b) {
        CalculationResult result = new CalculationResultBuilder().action(Action.ADD).result(a + b).build();
        dao.save(result);

        return result;
    }

    @Override
    @Transactional
    public CalculationResult multiply(double a, double b) {
        CalculationResult result = new CalculationResultBuilder().action(Action.MULTIPLY).result(a * b).build();
        dao.save(result);

        return result;
    }

    @Override
    @Transactional
    public CalculationResult divide(double a, double b) {
        CalculationResult result = new CalculationResultBuilder().action(Action.DIVIDE).result(a / b).build();
        dao.save(result);

        return result;
    }
}