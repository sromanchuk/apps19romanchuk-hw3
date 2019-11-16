package ua.edu.ucu.smartarr;

import ua.edu.ucu.functions.MyFunction;

// Map every element to another object using MyFunction
public class MapDecorator extends SmartArrayDecorator {

    public MapDecorator(SmartArray sa, MyFunction func) {
        super(sa);
        Object[] res = funcation(sa, func);
        this.smartArray = new BaseArray(res);
    }

    public Object[] funcation(SmartArray sa, MyFunction func) {
        Object[] arr = sa.toArray();
        Object[] res = new Object[arr.length];
        for (int i = 0; i < res.length; i++) {
            res[i] = func.apply(arr[i]);
        }
        return res;
    }

    @Override
    public Object[] toArray() {
        return this.smartArray.toArray();
    }

    @Override
    public String operationDescription() {
        return "apply function to smartArray";
    }

    @Override
    public int size() {
        return this.smartArray.toArray().length;
    }
}
