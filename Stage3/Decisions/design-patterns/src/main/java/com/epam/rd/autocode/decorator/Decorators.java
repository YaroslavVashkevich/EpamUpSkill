package com.epam.rd.autocode.decorator;

import java.util.List;

public class Decorators {

    public static List<String> evenIndexElementsSubList(List<String> sourceList) {
        return new ListDecorator(sourceList).listDecorator();
    }
}