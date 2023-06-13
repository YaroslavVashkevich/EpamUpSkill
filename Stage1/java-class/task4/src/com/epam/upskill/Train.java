package com.epam.upskill;

public class Train {
    private String city;
    private int train;
    private String time;

    public Train(String city, int train, String time) {
        this.city = city;
        this.train = train;
        this.time = time;
    }

    public String getCity() {
        return city;
    }

    public int getTrain() {
        return train;
    }

    public String getTime() {
        return time;
    }
}
