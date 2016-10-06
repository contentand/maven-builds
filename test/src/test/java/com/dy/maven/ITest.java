package com.dy.maven;

import org.junit.Test;

import static org.junit.Assert.*;

public class ITest {
    @Test
    public void execute() throws Exception {
        assertEquals(0, new Main().execute());
    }
}