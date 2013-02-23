package org.ankarajug.testinfected.service;

import org.ankarajug.testinfected.dao.CalculatorDao;
import org.ankarajug.testinfected.domain.CalculationResult;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.verify;

/**
 * User: mertcaliskan
 * Date: 2/19/13
 */
@RunWith(MockitoJUnitRunner.class)
public class CalculatorServiceImplTest {

    @Mock
    private CalculatorDao dao;

    @InjectMocks
    private CalculatorServiceImpl impl = new CalculatorServiceImpl();

    @Test
    public void addInvokedSuccessfullyAndReturnedCalculationResult() {
        impl.add(4, 5);

        verify(dao).save(any(CalculationResult.class));
    }

    @Test
    public void subtractInvokedSuccessfullyAndReturnedCalculationResult() {
        impl.subtract(6, 4);

        verify(dao).save(any(CalculationResult.class));
    }

    @Test
    public void multiplyInvokedSuccessfullyAndReturnedCalculationResult() {
        impl.multiply(6, 4);

        verify(dao).save(any(CalculationResult.class));
    }

    @Test
    public void divideInvokedSuccessfullyAndReturnedCalculationResult() {
        impl.divide(6, 6);

        verify(dao).save(any(CalculationResult.class));
    }
}
