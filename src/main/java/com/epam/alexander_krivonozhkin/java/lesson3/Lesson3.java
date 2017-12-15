package com.epam.alexander_krivonozhkin.java.lesson3;

import com.epam.alexander_krivonozhkin.java.lesson3.classes.Course;
import com.epam.alexander_krivonozhkin.java.lesson3.classes.Curriculum;
import com.epam.alexander_krivonozhkin.java.lesson3.classes.Student;

import java.time.LocalDateTime;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class Lesson3 {

    public void runTask(boolean inDetails) {
        Student ivan = new Student(
                "Ivanov Ivan",
                new Curriculum(
                        "J2EE Developer",
                        Arrays.asList(
                                new Course("Технология Java Servlets", 16),
                                new Course("Struts Framework", 24)
                        )
                ),
                LocalDateTime.of(2017, 12, 13, 10, 0)
        );
        Student petr = new Student(
                "Petrov Petr",
                new Curriculum(
                        "Java Developer ",
                        Arrays.asList(
                                new Course("Обзор технологий Java", 8),
                                new Course("Библиотека JFC/Swing", 16),
                                new Course("Технология JDBC", 16)
                        )
                ),
                LocalDateTime.of(2017, 12, 7, 12, 0)
        );

        ivan.show(inDetails);
        petr.show(inDetails);
    }

}
