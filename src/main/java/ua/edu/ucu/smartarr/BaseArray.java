package ua.edu.ucu.smartarr;

import java.util.Arrays;

// Base array for decorators
public class BaseArray implements SmartArray {

    private Object[] arr;

    public BaseArray(Object[] arr) {
        this.arr = Arrays.copyOf(arr, arr.length);
    }

    @Override
    public Object[] toArray() {
        return this.arr;
    }

    @Override
    public String operationDescription() {
        return null;
    }

    @Override
    public int size() {
        return this.arr.length;
    }
}
