package com.epam.alexander_krivonozhkin.java.lesson3.classes;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

public class Curriculum {

    protected String title;
    protected Date startDate;

    protected Schedule schedule = new Schedule();
    protected List<Course> courses = new ArrayList<>();

    public Curriculum(String title, Date startDate) {
        this.title = title;
        this.startDate = startDate;
    }

    public Curriculum(String title, Date startDate, Collection<Course> courses) {
        this(title, startDate);
        this.courses = new ArrayList<>(courses);
    }

    public Curriculum(String title, Date startDate, Collection<Course> courses, Schedule schedule) {
        this(title, startDate, courses);
        this.schedule = schedule;
    }

    public int getDurationInHours() {
        return courses
                .stream()
                .reduce(0, (sum, course) -> sum += course.duration, (sum1, sum2) -> sum1 + sum2);
    }

    public Date getFinishDate() {
        final int requiredDays = schedule.getRequiredDaysForHours(getDurationInHours());
        return Date.from(startDate.toInstant().plus(Duration.ofDays(requiredDays)));
    }

    public String getTitle() {
        return title;
    }

    public Curriculum setTitle(String title) {
        this.title = title;
        return this;
    }

    public Date getStartDate() {
        return startDate;
    }

    public Curriculum setStartDate(Date startDate) {
        this.startDate = startDate;
        return this;
    }

    public Schedule getSchedule() {
        return schedule;
    }

    public Curriculum setSchedule(Schedule schedule) {
        this.schedule = schedule;
        return this;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public Curriculum setCourses(List<Course> courses) {
        this.courses = courses;
        return this;
    }
}
