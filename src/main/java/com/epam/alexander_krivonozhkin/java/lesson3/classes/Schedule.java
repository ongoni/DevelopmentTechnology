package com.epam.alexander_krivonozhkin.java.lesson3.classes;

import java.util.Arrays;

public class Schedule {

    protected static int daysInWeek = 7;
    protected static int defaultDayDuration = 8;

    protected int[] hoursByDay = new int[daysInWeek];

    public Schedule() {
        Arrays.fill(hoursByDay, 0, hoursByDay.length - 1, defaultDayDuration);
    }

    public int getRequiredDaysForHours(int hours) {
        int i = 0;
        int days = 0;
        int countedHours = 0;

        while (countedHours < hours) {
            countedHours += hoursByDay[i++ % hoursByDay.length];
            days++;
        }

        return days;
    }

    public int[] getHoursByDay() {
        return hoursByDay;
    }

    public Schedule setHoursByDay(int[] hoursByDay) {
        this.hoursByDay = hoursByDay;
        return this;
    }

}
