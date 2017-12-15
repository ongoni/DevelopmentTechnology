package com.epam.alexander_krivonozhkin.java.lesson3.classes;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Curriculum {

    protected String title;
    protected List<Course> courses = new ArrayList<>();

    public Curriculum(String title) {
        this.setTitle(title);
    }

    public Curriculum(String title, Collection<Course> courses) {
        this(title);
        this.setCourses(new ArrayList<>(courses));
    }

    public void addCourse(Course course) {
        courses.add(course);
    }
    
    public void addCourses(Collection<Course> courses) {
        this.courses.addAll(courses);
    }
    
    public int getDurationInHours() {
        return courses
                .stream()
                .reduce(
                        0, 
                        (sum, course) -> sum += course.duration, 
                        (sum1, sum2) -> sum1 + sum2
                );
    }

    public String getTitle() {
        return title;
    }

    public Curriculum setTitle(String title) {
        this.title = title;
        return this;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public Curriculum setCourses(List<Course> courses) {
        this.courses = courses;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (Course course : courses) {
            result.append(course)
                    .append("  \t\n");
        }

        return result.append("ALL COURSES \t")
                .append(getDurationInHours())
                .toString();
    }
}
