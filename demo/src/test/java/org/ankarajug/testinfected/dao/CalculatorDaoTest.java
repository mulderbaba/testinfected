package org.ankarajug.testinfected.dao;

import org.ankarajug.testinfected.BaseIntegrationTestCase;
import org.ankarajug.testinfected.domain.CalculationResult;
import org.ankarajug.testinfected.domain.builder.Action;
import org.ankarajug.testinfected.domain.builder.CalculationResultBuilder;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * User: mertcaliskan
 * Date: 2/19/13
 */
public class CalculatorDaoTest extends BaseIntegrationTestCase {

    @Autowired
    private CalculatorDao dao;

    @Test
    @Transactional
    public void saveCalculationResultWorksOK() {
        CalculationResult result = new CalculationResultBuilder().param1(5).param2(4).result(9.0).action(Action.ADD).build();

        dao.save(result);

        assertThat(result.getId() > 0, is(true));

        CalculationResult fetchedResult = dao.findById(result);

        assertThat(fetchedResult.getParam1(), is(result.getParam1()));
        assertThat(fetchedResult.getParam2(), is(result.getParam2()));
        assertThat(fetchedResult.getAction(), is(result.getAction()));
        assertThat(fetchedResult.getResult(), is(result.getResult()));
    }
}