package com.epam.rd.autocode.decorator;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class ListDecorator {
    private List<String> sourceList;

    public ListDecorator(List<String> sourceList) {
        this.sourceList = sourceList;
    }

    public List<String> listDecorator() {
        ListIterator listIterator = sourceList.listIterator();
        List<String> newList = new ArrayList<>();
        while (listIterator.hasNext()) {
            Object element = listIterator.next();
            if (listIterator.nextIndex() % 2 != 0) {
                newList.add((String) element);
            }
        }
        return newList;
    }
}
