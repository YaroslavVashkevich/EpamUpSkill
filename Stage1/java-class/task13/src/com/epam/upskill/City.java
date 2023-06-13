package com.epam.upskill;

public class City {

    private String name;
    private boolean capital = false;

    public City(String name) {
        this.name = name;
    }

    public City(String name, boolean capital) {
        this.name = name;
        this.capital = capital;
    }

    public boolean isCapital() {
        return capital;
    }

    public String getName() {
        return name;
    }
}
