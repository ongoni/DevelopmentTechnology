package com.epam.alexander_krivonozhkin.java.lesson3;

import com.epam.alexander_krivonozhkin.java.lesson3.classes.Course;
import com.epam.alexander_krivonozhkin.java.lesson3.classes.Curriculum;
import com.epam.alexander_krivonozhkin.java.lesson3.classes.Schedule;
import com.epam.alexander_krivonozhkin.java.lesson3.classes.Student;

import java.util.*;
import java.util.concurrent.TimeUnit;

public class Lesson3 {

    public void runTask(boolean inDetails) {
        List<Student> students = new ArrayList<>();
        students.add(
                new Student(
                        "Ivanov Ivan",
                        new Curriculum(
                                "J2EE Developer",
                                new Date(),
                                Arrays.asList(
                                        new Course("Технология Java Servlets", 16),
                                        new Course("Struts Framework", 24)
                                ),
                                new Schedule()
                        )
                )
        );
        students.add(
                new Student(
                        "Petrov Petr",
                        new Curriculum(
                                "Java Developer ",
                                new Date(),
                                Arrays.asList(
                                        new Course("Обзор технологий Java", 8),
                                        new Course("Библиотека JFC/Swing", 16),
                                        new Course("Технология JDBC", 16)
                                ),
                                new Schedule()
                        )
                )
        );

        Date currentDate = new Date();
        if (!inDetails) {
            students.forEach(student -> {
                final Date finishDate = student.getCurriculum().getFinishDate();
                System.out.println(finishDate);
                final boolean finished = finishDate.before(currentDate);

                System.out.print(student.getName() + " (" + student.getCurriculum().getTitle() + ") – ");
                System.out.print("Обучение " + (!finished ? "не " : "") + "закончено. ");

                if (!finished) System.out.print("До окончания осталось ");
                else System.out.print("После окончания прошло ");

                final long duration = Math.abs(currentDate.getTime() - finishDate.getTime());
                final TimeUnit ms = TimeUnit.MILLISECONDS;
                final long days = ms.toDays(duration);

                System.out.println((days > 0 ? days + "д. " : "") + ms.toHours(duration) + "ч.");
            });
        } else {
            // in details here
        }
    }

}
