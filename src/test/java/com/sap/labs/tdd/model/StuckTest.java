package com.sap.labs.tdd.model;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class StuckTest {

    private Stuck classUnderTest;

    @Before
    public void setUp() throws Exception {
        classUnderTest = new Stuck(5);
    }

    @Test
    public void testStuckHasSizeZeroFirst() throws Exception {
        assertThat(classUnderTest.size(), is(0));
    }

    @Test
    public void testWhenAddingItemsSizeIncrease() throws Exception {
        classUnderTest.put(3);
        assertThat(classUnderTest.size(), is(1));
    }

    @Test
    public void testWhenAddingSeveralItemsSizeIncrease() throws Exception {
        for (int i = 0; i < 5; i++) {
            classUnderTest.put(i);
        }
        assertThat(classUnderTest.size(), is(5));
    }

    @Test
    public void testWhenPutThePopSizeDecrease() throws Exception {
        classUnderTest.put(3);
        classUnderTest.put(5);
        classUnderTest.pop();
        assertThat(classUnderTest.size(), is(1));
    }

    @Test
    public void testWhenPopReturnValue() throws Exception {
        classUnderTest.put(5);
        assertThat(classUnderTest.pop(), is(5));
    }

    @Test
    public void testPopReturnMultipleValues() throws Exception {
        classUnderTest.put(5);
        classUnderTest.put(4);

        assertThat(classUnderTest.pop(), is(4));
        assertThat(classUnderTest.pop(), is(5));
    }

    @Test (expected = OverFlowException.class)
    public void testThrowOverFlowException() throws Exception {
        int maxSize = 20;
        classUnderTest = new Stuck(maxSize);
        for (int i = 0; i < maxSize; i++) {
            classUnderTest.put(i);
        }
        classUnderTest.put(8);
    }
}