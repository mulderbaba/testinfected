package org.ankarajug.testinfected.gist;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

/**
 * User: mertcaliskan
 * Date: 2/22/13
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestCasesExecutionOrder {

    @Test
    public void secondTest() {
        System.out.println("Executing second test");
    }

    @Test
    public void firstTest() {
        System.out.println("Executing first test");
    }

    @Test
    public void thirdTest() {
        System.out.println("Executing third test");
    }
}