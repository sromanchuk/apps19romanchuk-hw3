package ua.edu.ucu.smartarr;

import java.lang.*;

import java.util.*;

// Remove duplicates from SmartArray. Use method equals() to compare objects
public class DistinctDecorator extends SmartArrayDecorator {
    public DistinctDecorator(SmartArray sa) {
        super(sa);
        Object[] res = distinction(sa);
        this.smartArray = new BaseArray(res);
    }

    public Object[] distinction(SmartArray sa) {
        Object[] arr = sa.toArray();
        Object[] res = new Object[arr.length];
        int k = 0;
        boolean flag = true;
        for (int i = 0; i < res.length; i++) {
            for (int j = i; j < res.length; j++) {
                if (arr[i].equals(arr[j]) && i != j) {
                    flag = false;
                }
            }
            if (flag) {
                res[k] = arr[i];
                k++;
            }
            flag = true;
        }
        return Arrays.copyOf(res, k);
    }

    @Override
    public Object[] toArray() {
        return this.smartArray.toArray();
    } // return array with SmartArray elements

    @Override
    public String operationDescription() {

        return "filter elements that repeat more than once";
    } // return current operation name applied to SmartArray

    @Override
    public int size() {
        return this.smartArray.toArray().length;
    } // return SmartArray size
}
