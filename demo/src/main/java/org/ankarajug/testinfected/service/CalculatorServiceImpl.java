package org.ankarajug.testinfected.service;

import org.ankarajug.testinfected.dao.CalculatorDao;
import org.ankarajug.testinfected.domain.CalculationResult;
import org.ankarajug.testinfected.domain.builder.Action;
import org.ankarajug.testinfected.domain.builder.CalculationResultBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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
    public CalculationResult add(Integer a, Integer b) {
        CalculationResult result = new CalculationResultBuilder().action(Action.ADD).param1(a).param2(b).result(Double.valueOf(a + b)).build();
        dao.save(result);

        return result;
    }

    @Override
    @Transactional
    public CalculationResult subtract(Integer a, Integer b) {
        CalculationResult result = new CalculationResultBuilder().action(Action.SUBTRACT).param1(a).param2(b).result(Double.valueOf(a - b)).build();
        dao.save(result);

        return result;
    }

    @Override
    @Transactional
    public CalculationResult multiply(Integer a, Integer b) {
        CalculationResult result = new CalculationResultBuilder().action(Action.MULTIPLY).param1(a).param2(b).result(Double.valueOf(a * b)).build();
        dao.save(result);

        return result;
    }

    @Override
    @Transactional
    public CalculationResult divide(Integer a, Integer b) {
        CalculationResult result = new CalculationResultBuilder().action(Action.DIVIDE).param1(a).param2(b).result((double)a / (double)b).build();
        dao.save(result);

        return result;
    }

    @Override
    public List<CalculationResult> getAll() {
        return dao.getAll();
    }
}