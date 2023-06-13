package com.epem.upskill;

public class Student {
    private String name;
    private String group;
    private int[] grades;

    public Student(String name, String group, int[] grades) {
        this.name = name;
        this.group = group;
        this.grades = grades;
    }

    public String getName() {
        return name;
    }

    public String getGroup() {
        return group;
    }

    public int[] getGrades() {
        return grades;
    }
}
