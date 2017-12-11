package com.epam.alexander_krivonozhkin.java.lesson3.classes;

public class Course {

    protected String title;
    protected int duration;

    public Course(String title, int duration) {
        this.setTitle(title)
                .setDuration(Math.max(duration, 0));
    }

    public String getTitle() {
        return title;
    }

    public Course setTitle(String title) {
        this.title = title;
        return this;
    }

    public int getDuration() {
        return duration;
    }

    public Course setDuration(int duration) {
        this.duration = duration;
        return this;
    }

}
