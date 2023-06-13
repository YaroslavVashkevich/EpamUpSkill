package com.epam.rd.autocode.iterator;

import java.util.Iterator;

public class StrIterator implements Iterator {
    private String[] array;
    int index = 0;

    public StrIterator(String[] array) {
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
