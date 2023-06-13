package com.epam.upskill;

public class Time {
    private int hour;
    private int minute;
    private int second;
    private int changeHour;
    private int changeMinute;
    private int changeSecond;


    public void setHour(int hour) {
        if (hour > 23 || hour < 0)
            this.hour = 0;
        else this.hour = hour;
    }

    public void setMinute(int minute) {
        if (minute > 59 || minute < 0)
            this.minute = 0;
        else
            this.minute = minute;
    }

    public void setSecond(int second) {
        if (second > 59 || second < 0)
            this.second = 0;
        else
            this.second = second;
    }

    public void setChangeHour(int changeHour) {
        if ((changeHour + hour) > 23)
            this.changeHour = 0;
        else this.changeHour = changeHour + hour;
    }

    public void setChangeMinute(int changeMinute) {
        if ((changeMinute + minute) > 59)
            this.changeMinute = 0;
        else this.changeMinute = changeMinute + minute;
    }

    public void setChangeSecond(int changeSecond) {
        if ((changeSecond + second) > 59)
            this.changeSecond = 0;
        else this.changeSecond = changeSecond + second;
    }

    public int getHour() {
        return hour;
    }

    public int getMinute() {
        return minute;
    }

    public int getSecond() {
        return second;
    }

    public int getChangeHour() {
        return changeHour;
    }

    public int getChangeMinute() { return changeMinute; }

    public int getChangeSecond() {
        return changeSecond;
    }

}
