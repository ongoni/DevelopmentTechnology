package com.epam.alexander_krivonozhkin.java.lesson3.classes;

import java.util.Arrays;

public class Schedule {

    protected static int daysInWeek = 7;
    protected static int defaultDayDuraion = 8;

    protected int[] hoursByDay = new int[daysInWeek];

    Schedule() {
        Arrays.fill(hoursByDay, 0, hoursByDay.length - 1, defaultDayDuraion);
    }

    Schedule(int[] hoursByDay) {
        this();
        for (int i = 0; i < hoursByDay.length; i++) setHoursAt(i, hoursByDay[i]);
    }

    public void setHoursAt(int day, int hours) {
        if (day < 0 || day >= hoursByDay.length) return;

        hoursByDay[day] = Math.max(Math.min(hours, 24), 0);
    }

    public int getTotalHours() {
        return Arrays.stream(hoursByDay).sum();
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

}
