package com.epam.upskill;

public class Wheel {
    private String model;
    private boolean rotating = false;

    public Wheel(String model) {
        this.model = model;

    }

    public boolean rotating(boolean rotating) {
        this.rotating = rotating;
        return this.rotating;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String toString() {
        return model;
    }
}
