package com.epam.rd.autocode.bstprettyprint;

public interface PrintableTree {

    void add(int i);

    String prettyPrint();

    static PrintableTree getInstance() {
        PrintableTree tree = new PrintableTreeImpl();
        return tree;
    }
}
