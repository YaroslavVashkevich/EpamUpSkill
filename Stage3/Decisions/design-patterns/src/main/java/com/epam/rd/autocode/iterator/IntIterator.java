package com.epam.rd.autocode.iterator;

import java.util.Iterator;

public class IntIterator implements Iterator {
    private int[] array;
    private int index = 0;

    public IntIterator(int[] array) {
        this.array = array;
    }

    @Override
    public boolean hasNext() {
        if (index < array.length) {
            return true;
        }
        return false;
    }

    @Override
    public Object next() {
        return array[index++];
    }
}
