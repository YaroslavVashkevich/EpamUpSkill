package com.epam.upskill;

public class Airline {
    private String city;
    private int flight;
    private String plane;
    private String time;
    private String weekday;

    public Airline(String city, int flight, String plane, String time, String weekday) {
        this.city = city;
        this.flight = flight;
        this.plane = plane;
        this.time = time;
        this.weekday = weekday;
    }

    public String getCity() {
        return city;
    }

    public int getFlight() {
        return flight;
    }

    public String getPlane() {
        return plane;
    }

    public String getTime() {
        return time;
    }

    public String getWeekday() {
        return weekday;
    }

    @Override
    public String toString() {
        return "Flight number " + flight +
                "  " + city +
                "  " + plane +
                "  " + weekday +
                "  " + time;
    }
}


