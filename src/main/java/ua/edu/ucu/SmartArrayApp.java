package ua.edu.ucu;

import java.util.Arrays;
import ua.edu.ucu.functions.MyComparator;
import ua.edu.ucu.functions.MyFunction;
import ua.edu.ucu.functions.MyPredicate;
import ua.edu.ucu.smartarr.*;

public class SmartArrayApp {

    public static Integer[]
    filterPositiveIntegersSortAndMultiplyBy2(Integer[] integers) {

        MyPredicate pr = new MyPredicate() {
            @Override
            public boolean test(Object t) {
                return ((Integer) t) > 0;
            }
        };

        MyComparator cmp = new MyComparator() {
            @Override
            public int compare(Object o1, Object o2) {
                return ((Integer) o1) - ((Integer) o2);
            }
        };

        MyFunction func = new MyFunction() {
            @Override
            public Object apply(Object t) {
                return 2 * ((Integer) t);
            }
        };

        SmartArray sa = new BaseArray(integers);

        sa = new FilterDecorator(sa, pr);
        sa = new SortDecorator(sa, cmp);
        sa = new MapDecorator(sa, func);

        // Alternative
//        sa = new MapDecorator(
//                    new SortDecorator(
//                        new FilterDecorator(sa, pr),
//                    cmp),
//                func);
        Object[] result = sa.toArray();
        return Arrays.copyOf(result, result.length, Integer[].class);
    }

    public static String[]
    findDistinctStudentNamesFrom2ndYearWithGPAgt4AndOrderedBySurname(Student[] students) {


        MyPredicate prGPA = new MyPredicate() {
            @Override
            public boolean test(Object t) {
                Student st = (Student) t;
                return st.getGPA() >= 4;
            }
        };

        MyPredicate prYear = new MyPredicate() {
            @Override
            public boolean test(Object t) {
                Student st = (Student) t;
                return st.getYear() == 2;
            }
        };

        MyComparator cmpSurname = new MyComparator() {
            @Override
            public int compare(Object o1, Object o2) {
                Student st1 = (Student) o1;
                Student st2 = (Student) o2;
                String str1 = st1.getSurname();
                String str2 = st2.getSurname();
                int len1 = str1.length();
                int len2 = str2.length();
                int minLen = Math.min(len1, len2);
                for (int i = 0; i < minLen; i++) {
                    if (str1.charAt(i) != str2.charAt(i)) {
                        return str1.charAt(i) - str2.charAt(i);
                    }
                }
                if (len1 != len2) {
                    return len1 - len2;
                }
                else {
                    return 0;
                }


            }
        };

        MyFunction funcName = new MyFunction() {
            @Override
            public Object apply(Object t) {
                Student st = (Student) t;
                return st.getSurname() + " " + st.getName();
            }
        };

        SmartArray studentSmartArray = new BaseArray(students);
        studentSmartArray = new FilterDecorator(studentSmartArray, prGPA);
        studentSmartArray = new FilterDecorator(studentSmartArray, prYear);
        studentSmartArray = new SortDecorator(studentSmartArray, cmpSurname);
        studentSmartArray = new MapDecorator(studentSmartArray, funcName);
        studentSmartArray = new DistinctDecorator(studentSmartArray);

        // Hint: to convert Object[] to String[] - use the following code
        Object[] result = studentSmartArray.toArray();
        return Arrays.copyOf(result, result.length, String[].class);

    }
}
