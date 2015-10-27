package com.sap.labs.tdd.model;

/**
 * Created by I062070 on 27/10/2015.
 */
public class Stuck {
    private int size = 0;
    private int[] values;

    public Stuck(int size) {
        values = new int[size];
    }

    public int size() {
        return size;
    }

    public void put(int value) throws OverFlowException {
        if (size != values.length) {
            values[size++] = value;
        } else {
            throw new OverFlowException();
        }
    }

    public int pop() {
        int result = values[--size];
        return result;
    }
}
