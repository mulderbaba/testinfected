package org.ankarajug.testinfected.domain.builder;

import org.ankarajug.testinfected.domain.CalculationResult;

/**
 * User: mertcaliskan
 * Date: 2/18/13
 */
public class CalculationResultBuilder {

    private Action action;
    private Double result;

    public CalculationResult build() {
        CalculationResult calculationResult = new CalculationResult();
        calculationResult.setAction(action);
        calculationResult.setResult(result);

        return calculationResult;
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
