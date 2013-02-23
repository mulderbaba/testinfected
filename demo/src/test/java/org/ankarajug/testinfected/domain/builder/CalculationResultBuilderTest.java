package org.ankarajug.testinfected.domain.builder;

import org.ankarajug.testinfected.domain.CalculationResult;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * User: mertcaliskan
 * Date: 2/18/13
 */
public class CalculationResultBuilderTest {

    CalculationResultBuilder builder;

    @Before
    public void setup() {
        builder = new CalculationResultBuilder();
    }

    @Test
    public void calculationResultGetsBuildOK() {
        CalculationResult result = builder.param1(5).param2(4).result(9.0).action(Action.ADD).build();

        assertThat(result.getParam1(), is(5.0));
        assertThat(result.getParam2(), is(4.0));
        assertThat(result.getResult(), is(9.0));
        assertThat(result.getAction(), is(Action.ADD));
    }
}
