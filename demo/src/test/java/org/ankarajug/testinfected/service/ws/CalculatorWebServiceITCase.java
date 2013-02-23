package org.ankarajug.testinfected.service.ws;

import org.ankarajug.testinfected.BaseWebServiceIntegrationTestCase;
import org.ankarajug.testinfected.domain.CalculationResult;
import org.junit.Test;

import static junit.framework.TestCase.assertNotNull;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * User: mertcaliskan
 * Date: 2/19/13
 */
public class CalculatorWebServiceITCase extends BaseWebServiceIntegrationTestCase<CalculatorWebService> {

    @Test
    public void addOperationInvokedSuccessfullyViaWS() {
        CalculatorWebService serviceClient = createServiceClient("/calculatorWS");

        CalculationResult calculationResult = serviceClient.add(4, 5);

        assertNotNull(calculationResult);
        assertThat(calculationResult.getResult(), is(9.0));
    }

    @Test
    public void substractOperationInvokedSuccessfullyViaWS() {
        CalculatorWebService serviceClient = createServiceClient("/calculatorWS");

        CalculationResult calculationResult = serviceClient.substract(6, 1);

        assertNotNull(calculationResult);
        assertThat(calculationResult.getResult(), is(5.0));
    }

    @Test
    public void multiplyOperationInvokedSuccessfullyViaWS() {
        CalculatorWebService serviceClient = createServiceClient("/calculatorWS");

        CalculationResult calculationResult = serviceClient.multiply(5, 4);

        assertNotNull(calculationResult);
        assertThat(calculationResult.getResult(), is(20.0));
    }

    @Test
    public void divideOperationInvokedSuccessfullyViaWS() {
        CalculatorWebService serviceClient = createServiceClient("/calculatorWS");

        CalculationResult calculationResult = serviceClient.divide(4, 2);

        assertNotNull(calculationResult);
        assertThat(calculationResult.getResult(), is(2.0));
    }
}