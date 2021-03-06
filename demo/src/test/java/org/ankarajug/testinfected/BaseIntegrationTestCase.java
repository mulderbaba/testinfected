package org.ankarajug.testinfected;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

/**
 * User: mertcaliskan
 * Date: 2/9/13
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/applicationContext-test.xml"})
@TransactionConfiguration(defaultRollback = false, transactionManager = "transactionManager")
public abstract class BaseIntegrationTestCase {
}
