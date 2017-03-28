package com.sapirgol.tdd.bst;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * Created by I062070 on 28/03/2017.
 */
public class BSTTest {
    private BinarySearchTree classUnderTest;

    @Before
    public void setUp() throws Exception {
        classUnderTest = new BinarySearchTree();
    }

    @Test
    public void insertAndGetRoot() throws Exception {
        classUnderTest.put(8);
        assertThat(classUnderTest.contains(8), is(true));
    }

    @Test
    public void insertRootAndSearchForNonExistingValue() throws Exception {
        classUnderTest.put(8);
        assertThat(classUnderTest.contains(7), is(false));
    }

    @Test
    public void insertRootAndLeftNode() throws Exception {
        classUnderTest.put(8);
        classUnderTest.put(7);
        assertThat(classUnderTest.contains(8), is(true));
        assertThat(classUnderTest.contains(7), is(true));
    }

    @Test
    public void insertRootAndRightNode() throws Exception {
        classUnderTest.put(8);
        classUnderTest.put(9);
        assertThat(classUnderTest.contains(8), is(true));
        assertThat(classUnderTest.contains(9), is(true));
    }

    @Test
    public void insertRootAndRightAndRightNode() throws Exception {
        classUnderTest.put(8);
        classUnderTest.put(9);
        classUnderTest.put(10);
        classUnderTest.put(11);
        classUnderTest.put(120);

        assertThat(classUnderTest.contains(8), is(true));
        assertThat(classUnderTest.contains(9), is(true));
        assertThat(classUnderTest.contains(10), is(true));
        assertThat(classUnderTest.contains(120), is(true));
    }
}
