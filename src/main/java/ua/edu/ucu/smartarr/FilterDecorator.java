package ua.edu.ucu.smartarr;

import java.util.*;

import ua.edu.ucu.functions.MyPredicate;

// Tests every element and removes it if it doesn't satisfy MyPredicate
public class FilterDecorator extends SmartArrayDecorator {

    public FilterDecorator(SmartArray sa, MyPredicate pr) {
        super(sa);
        Object[] res = this.predication(sa,pr);
        this.smartArray = new BaseArray(res);
    }

    public Object[] predication(SmartArray sa, MyPredicate pr) {
        Object[] arr = sa.toArray();
        Object[] res = new Object[arr.length];
        int k = 0;
        for (int i = 0; i < res.length; i++) {
            if (pr.test(arr[i]) == true) {
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
        return "filter unacceptable elements from array by predicate";
    }

    @Override
    public int size() {
        return this.smartArray.toArray().length;
    }
}
