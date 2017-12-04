package com.epam.alexander_krivonozhkin.java.lesson3;

import com.epam.alexander_krivonozhkin.java.lesson3.classes.Student;

import java.util.*;
import java.util.concurrent.TimeUnit;

public class Lesson3 {

    public void runTask(boolean inDetails) {
        List<Student> students = new ArrayList<>();

        Date currentDate = new Date();
        if (!inDetails) {
            students.forEach(student -> {
                final Date finishDate = student.getCurriculum().getFinishDate();
                final boolean finished = finishDate.after(currentDate);

                System.out.print(student.getName() + " (" + student.getCurriculum().getTitle() + ") – ");
                System.out.print("Обучение " + (finished ? "не " : "") + "закончено.");

                if (!finished) System.out.print("До окончания осталось ");
                else System.out.print("После окончания прошло ");

                final long duration = Math.abs(currentDate.getTime() - finishDate.getTime());
                final TimeUnit ms = TimeUnit.MILLISECONDS;
                final long days = ms.toDays(duration);

                System.out.print((days > 0 ? days + "д. " : "") + ms.toHours(duration) + "ч.");
            });
        } else {
            // in details here
        }
    }

}
