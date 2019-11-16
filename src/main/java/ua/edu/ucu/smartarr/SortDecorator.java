package ua.edu.ucu.smartarr;

import ua.edu.ucu.functions.MyComparator;

import java.util.*;

// Sorts elements using MyComparator to compare them
public class SortDecorator extends SmartArrayDecorator {

    public SortDecorator(SmartArray sa, MyComparator cmp) {
        super(sa);
        Object[] res = sa.toArray();
        Arrays.sort(res, cmp);
        this.smartArray = new BaseArray(res);
    }

    @Override
    public Object[] toArray() {
        return this.smartArray.toArray();
    }

    @Override
    public String operationDescription(){
        return "sort smartArray";
    }

    @Override
    public int size() {
        return this.smartArray.toArray().length;
    }
}
