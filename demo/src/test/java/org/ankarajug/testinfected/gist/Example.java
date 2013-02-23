package org.ankarajug.testinfected.gist;


import org.junit.Test;

import java.util.ArrayList;

/**
 * User: mertcaliskan
 * Date: 2/22/13
 */
public class Example {

    @Test
    public void method() {
        org.junit.Assert.assertTrue(new ArrayList().isEmpty());
    }
}