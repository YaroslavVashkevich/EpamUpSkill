package com.epam.upskill;

public class Triangle {
    private int x1;
    private int y1;
    private int x2;
    private int y2;
    private int x3;
    private int y3;

    public void setX1(int x1) {
        this.x1 = x1;
    }

    public void setY1(int y1) { this.y1 = y1; }

    public void setX2(int x2) { this.x2 = x2; }

    public void setY2(int y2) { this.y2 = y2; }

    public void setX3(int x3) { this.x3 = x3; }

    public void setY3(int y3) { this.y3 = y3; }

    public boolean getCheck() {
        if ((x2 - x1) * (y3 - y1) - (y2 - y1) * (x3 - x1) == 0) {
            return true;
        } else {
            return false;
        }
    }

    public double getA() {
        double a = Math.sqrt(Math.pow((x2 - x1), 2) + Math.pow((y2 - y1), 2));
        return a;
    }

    public double getB() {
        double b = Math.sqrt(Math.pow((x3 - x1), 2) + Math.pow((y3 - y1), 2));
        return b;
    }

    public double getC() {
        double c = Math.sqrt(Math.pow((x3 - x2), 2) + Math.pow((y3 - y2), 2));
        return c;
    }
    public double getP() {
        double p = Math.round(getA() + getB() + getC());
        return p;
    }
    public double getS() {
        double s = Math.round(Math.sqrt((getP()/2) * ((getP()/2) - getA()) * ((getP()/2) - getB()) * ((getP()/2) - getC())));
        return s;
    }

    public int getMx() {
        int mx = (x1 + x2 + x3) / 3;
        return mx;
    }
    public int getMy() {
        int my = (y1 + y2 + y3) / 3;
        return my;
    }

}
