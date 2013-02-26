package org.ankarajug.testinfected.domain.builder;

import org.ankarajug.testinfected.domain.CalculationResult;

/**
 * User: mertcaliskan
 * Date: 2/18/13
 */
public class CalculationResultBuilder {

    private Integer param1;
    private Integer param2;
    private Double result;
    private Action action;

    public CalculationResult build() {
        CalculationResult calculationResult = new CalculationResult();
        calculationResult.setParam1(param1);
        calculationResult.setParam2(param2);
        calculationResult.setAction(action);
        calculationResult.setResult(result);

        return calculationResult;
    }

    public CalculationResultBuilder param1(Integer param1) {
        this.param1 = param1;
        return this;
    }

    public CalculationResultBuilder param2(Integer param2) {
        this.param2 = param2;
        return this;
    }

    public CalculationResultBuilder result(Double result) {
        this.result = result;
        return this;
    }

    public CalculationResultBuilder action(Action action) {
        this.action = action;
        return this;
    }
}