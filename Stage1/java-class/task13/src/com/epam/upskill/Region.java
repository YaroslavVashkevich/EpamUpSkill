package com.epam.upskill;

public class Region {
    private String name;
    private District[] districts;
    private double area;

    public Region(String name, double area, District... districts) {

        this.area = area;
        this.name = name;
        this.districts = districts;
    }

    public District[] getDistricts() {
        return districts;
    }

    public double getArea() {
        return area;
    }
}

