package org.ankarajug.testinfected.gist;

import org.junit.Before;
import org.junit.Test;

/**
 * User: mertcaliskan
 * Date: 2/22/13
 */
public class BeforeOrderSample {

    @Before
    public void finalSetup() {
        System.out.println("final stuff");
    }

    @Test
    public void doTheTest() {
        System.out.println("test test test");
    }

    @Before
    public void initialSetup() {
        System.out.println("initial stuff");
    }
}