package com.epam.upskill;

public class Counter {
    private int max;
    private int min;
    private int count;

    public Counter() {
        min = 10;
        max = 20;
        count = 13;
    }

    public Counter(int min, int max, int count) throws Exception {
        if (min > max)
            throw new Exception("Wrong range!");
        if (count < min || (count > max))
            throw new Exception("Wrong range!");
        this.min = min;
        this.max = max;
        this.count = count;
    }

    public int getMin() {
        return min;
    }

    public int getMax() {
        return max;
    }

    public int getCount() {
        return count;
    }

    public int getValue() {
        int value = count;
        return value;
    }

    public int getNext() throws Exception {
        int value = getValue();
        value++;
        if (value > max)
            throw new Exception("Value is exceeded!");
        return value;
    }

    public int getPrevious() throws Exception {
        int value = getValue();
        value--;
        if (value < min)
            throw new Exception("Value is exceeded!");
        return value;

    }

    public void setMin(int min) {
        this.min = min;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public void setCount(int count) throws Exception {
        if (count < min || count > max)
            throw new Exception("Wrong range!");
        this.count = count;
    }

}
