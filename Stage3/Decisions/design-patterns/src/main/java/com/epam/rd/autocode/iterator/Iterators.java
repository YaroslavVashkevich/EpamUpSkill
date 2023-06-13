package com.epam.rd.autocode.iterator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

class Iterators {

    public static Iterator<Integer> intArrayTwoTimesIterator(int[] array) {
        List<Integer> iteratorInteger = new ArrayList<>();
        IntIterator li = new IntIterator(array);
        while (li.hasNext()) {
            Object element = li.next();
            iteratorInteger.add((Integer) element);
            iteratorInteger.add((Integer) element);
        }
        /*for (int s:array) {
            iteratorInteger.add(s);
            iteratorInteger.add(s);
        }*/
        Iterator<Integer> iterator = iteratorInteger.iterator();
        return iterator;
    }

    public static Iterator<Integer> intArrayThreeTimesIterator(int[] array) {
        IntIterator li = new IntIterator(array);
        List<Integer> iteratorInteger = new ArrayList<>();
        while (li.hasNext()) {
            Object element = li.next();
            for (int i = 0; i < 3; i++) {
                iteratorInteger.add((Integer) element);
            }
        }
        Iterator<Integer> iterator = iteratorInteger.iterator();
        return iterator;
    }

    public static Iterator<Integer> intArrayFiveTimesIterator(int[] array) {
        IntIterator li = new IntIterator(array);
        List<Integer> iteratorInteger = new ArrayList<>();
        while (li.hasNext()) {
            Object element = li.next();
            for (int i = 0; i < 5; i++) {
                iteratorInteger.add((Integer) element);
            }
        }
        Iterator<Integer> iterator = iteratorInteger.iterator();
        return iterator;
    }

    public static Iterable<String> table(String[] columns, int[] rows) {
        //Iterator li = Arrays.asList(columns).iterator();
        StrIterator li = new StrIterator(columns);
        List<String> iteratorString = new ArrayList<>();
        while (li.hasNext()) {
            Object element = li.next();
            for (int i = 0; i < rows.length; i++) {
                iteratorString.add((String) element + rows[i]);
            }
        }
        return iteratorString;
    }

}
