package com.epam.alexander_krivonozhkin.java;

import com.epam.alexander_krivonozhkin.java.collections.reList;
import com.epam.alexander_krivonozhkin.java.lesson1.Lesson1;
import com.epam.alexander_krivonozhkin.java.lesson2.Lesson2;
import com.epam.alexander_krivonozhkin.java.lesson3.Lesson3;

import java.util.Date;

public class Main {

    public static void main(String[] args) {
//        Lesson1 lesson1 = new Lesson1();
//        lesson1.runTask1();
//        lesson1.runTask2();
//        lesson1.runTask3();

//        Lesson2 lesson2 = new Lesson2();
//        lesson2.runTask();

        Lesson3 lesson3 = new Lesson3();
        lesson3.runTask(false);

        reList<Integer> reList = new reList<>();
        for (int i = 0; i < 10; i++) reList.add(i);
        for (int i = 0; i < reList.size(); i++) System.out.print(reList.get(i) + " ");
    }

}