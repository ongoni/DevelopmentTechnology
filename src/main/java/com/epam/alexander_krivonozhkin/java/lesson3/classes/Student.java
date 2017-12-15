package com.epam.alexander_krivonozhkin.java.lesson3.classes;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class Student {

    protected String name;
    protected Curriculum curriculum;
    protected LocalDateTime startDate;

    public Student(String name, Curriculum curriculum, LocalDateTime startDate) {
        this.setName(name)
                .setCurriculum(curriculum)
                .setStartDate(startDate);
    }

    private LocalDateTime getFinishDate() {
        int allCurriculumLength = curriculum.getDurationInHours();
        LocalDateTime finishDate;

        if (allCurriculumLength % 8 == 0) {
            finishDate = startDate
                    .plusDays(allCurriculumLength / 8 - 1)
                    .withHour(18)
                    .withMinute(0);
            if (startDate.getHour() >= 10) {
                finishDate = finishDate.plusDays(1);
                if (startDate.getHour() < 18) {
                    finishDate = finishDate
                            .withHour(startDate.getHour())
                            .withMinute(startDate.getMinute());
                }
            }
        }
        else {
            finishDate = startDate.plusDays(allCurriculumLength / 8)
                    .withHour(10)
                    .withMinute(0)
                    .plusHours(allCurriculumLength % 8);
            if (startDate.getHour() >= 18) {
                finishDate = finishDate
                        .plusDays(1)
                        .withHour(10)
                        .withMinute(0)
                        .plusHours(allCurriculumLength % 8);
            }
            else {
                if (startDate.getHour() >= 10) {
                    finishDate = finishDate
                            .plusHours(startDate.getHour() - 10)
                            .withMinute(startDate.getMinute());
                    if (finishDate.getHour() > 18) {
                        finishDate = finishDate
                                .plusDays(1)
                                .withHour(finishDate.getHour() - 8);
                    }
                }
            }
        }

        return finishDate;
    }

    private String getRemainingTime() {
        StringBuilder result = new StringBuilder();
        LocalDateTime finishDate = getFinishDate();

        if (LocalDateTime.now().isAfter(finishDate)) {
            result.append("Обучение закончено. После окончания прошло: ")
                    .append(finishDate.until(LocalDateTime.now(), ChronoUnit.DAYS)).append(" д. ")
                    .append((finishDate.until(LocalDateTime.now(), ChronoUnit.HOURS)) % 24).append(" ч.");

        }
        else {
            int hours = 0;
            long days = LocalDateTime.now().until(finishDate, ChronoUnit.DAYS);

            if (LocalDateTime.now().getHour() >= 18) hours += (finishDate.getHour() - 10);
            else {
                if (LocalDateTime.now().getHour() < 10) days++;
                else hours += LocalDateTime.now().getHour() - 10;
                hours += finishDate.getHour() - 10;
            }

            if (hours >= 8) {
                days++;
                hours = hours % 8;
            }
            result.append("Обучение не закончено. До окончания осталось: ")
                    .append(days).append(" д. ")
                    .append(hours).append(" ч. (в рассчёте на учебное время)");
        }

        return result.toString();
    }

    public void show(boolean detailed) {
        if (!detailed) {
            System.out.println("STUDENT:" + name + " " + getRemainingTime() + "\n");
        } else {
            System.out.println("STUDENT:    \t" + name + " \n"
                            + "CURRICULUM: \t" + curriculum.title + "\n"
                            + "START_DATE: \t" + startDate.toString() + "\n"
                            + "FINISH_DATE:\t" + getFinishDate().toString() + "\n"
                            + "COURSE      \t DURATION(hrs)\n"+ curriculum.toString() + "\n"
                            + getRemainingTime() + '\n'
            );
        }
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

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public Student setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
        return this;
    }
}
