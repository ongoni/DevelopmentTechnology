package com.epam.alexander_krivonozhkin.java.lesson3.classes;

public class Student {

    protected String name;
    protected Curriculum curriculum;

    public Student(String name, Curriculum curriculum) {
        this.setName(name)
                .setCurriculum(curriculum);
    }

    public String getName() {
        return name;
    }

    public Student setName(String name) {
        this.name = name;
        return this;
    }

    public Curriculum getCurriculum() {
        return curriculum;
    }

    public Student setCurriculum(Curriculum curriculum) {
        this.curriculum = curriculum;
        return this;
    }

}
