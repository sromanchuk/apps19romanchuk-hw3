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
        for (int i = 0; i < res.length - 1; i++) {
            for (int j = i + 1; j < res.length; j++) {
                if (arr[i].equals(arr[j])) {
                    flag = false;
                }
            }
            if (flag) {
                res[k] = arr[i];
                k++;
            }
        }
        return Arrays.copyOf(res, k);
    }

    @Override
    public Object[] toArray() {
        return this.smartArray.toArray();
    }

    @Override
    public String operationDescription() {
        return "filter elements that repeat more than once";
    }

    @Override
    public int size() {
        return this.smartArray.toArray().length;
    }
}
