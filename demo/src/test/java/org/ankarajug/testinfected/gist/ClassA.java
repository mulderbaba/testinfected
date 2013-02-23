package org.ankarajug.testinfected.gist;

import org.junit.After;
import org.junit.Before;

/**
 * User: mertcaliskan
 * Date: 2/22/13
 */
public class ClassA {

    @Before
    public void classASetup() {
        System.out.println("class A setup");
    }

    @After
    public void classATearDown() {
        System.out.println("class A tear down");
    }
}