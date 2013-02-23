package org.ankarajug.testinfected.gist;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * User: mertcaliskan
 * Date: 2/22/13
 */
public class ClassB extends ClassA {

    @Before
    public void classBSetup() {
        System.out.println("class B setup");
    }

    @After
    public void classBTearDown() {
        System.out.println("class B tear down");
    }

    @Test
    public void doTheTest() {
        System.out.println("test test test");
    }
}
