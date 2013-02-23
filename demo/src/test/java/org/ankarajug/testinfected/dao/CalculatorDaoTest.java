package org.ankarajug.testinfected.dao;

import org.ankarajug.testinfected.BaseIntegrationTestCase;
import org.ankarajug.testinfected.domain.CalculationResult;
import org.ankarajug.testinfected.domain.builder.Action;
import org.ankarajug.testinfected.domain.builder.CalculationResultBuilder;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertNotNull;

/**
 * User: mertcaliskan
 * Date: 2/19/13
 */
public class CalculatorDaoTest extends BaseIntegrationTestCase {

    @Autowired
    private CalculatorDao dao;

    @Test
    @Transactional
    public void saveAndDeleteCalculationResultWorksOK() {
        CalculationResult result = new CalculationResultBuilder().param1(5).param2(4).result(9.0).action(Action.ADD).build();

        dao.save(result);

        assertThat(result.getId() > 0, is(true));

        CalculationResult fetchedResult = dao.findById(result);

        assertNotNull(fetchedResult);
        assertThat(fetchedResult.getParam1(), is(result.getParam1()));
        assertThat(fetchedResult.getParam2(), is(result.getParam2()));
        assertThat(fetchedResult.getAction(), is(result.getAction()));
        assertThat(fetchedResult.getResult(), is(result.getResult()));

        dao.delete(result);
    }

    @Test
    @Transactional
    public void saveAllAndGetAllCalculationResultsWorksOK() {
        CalculationResult result1 = new CalculationResultBuilder().param1(1).param2(2).result(3.0).action(Action.ADD).build();
        CalculationResult result2 = new CalculationResultBuilder().param1(6).param2(2).result(12.0).action(Action.DIVIDE).build();

        dao.save(Arrays.asList(result1, result2));

        List<CalculationResult> resultList = dao.getAll();

        assertNotNull(resultList);
        assertThat(resultList.size(), is(2));
        assertThat(resultList.get(0).getParam1(), is(1.0));
        assertThat(resultList.get(0).getParam2(), is(2.0));
        assertThat(resultList.get(0).getResult(), is(3.0));
        assertThat(resultList.get(0).getAction(), is(Action.ADD));

        assertThat(resultList.get(1).getParam1(), is(6.0));
        assertThat(resultList.get(1).getParam2(), is(2.0));
        assertThat(resultList.get(1).getResult(), is(12.0));
        assertThat(resultList.get(1).getAction(), is(Action.DIVIDE));
    }
}