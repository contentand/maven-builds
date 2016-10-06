package com.dy.maven;

import org.junit.Test;

import static org.junit.Assert.*;

public class SimpleTest {
    @Test
    public void perform() throws Exception {
        assertEquals(1, new Main().perform());
    }
}