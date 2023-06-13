package com.epam.rd.autocode.factory.plot;

public class ListPlots implements Plot {
    private String plot;

    public ListPlots(String plot) {
        this.plot = plot;
    }

    @Override
    public String toString() {
        return plot;
    }
}