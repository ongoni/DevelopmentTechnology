package com.epam.alexander_krivonozhkin.java;

import com.epam.alexander_krivonozhkin.java.collections.reList;
import com.epam.alexander_krivonozhkin.java.lesson1.Lesson1;
import com.epam.alexander_krivonozhkin.java.lesson2.Lesson2;
import com.epam.alexander_krivonozhkin.java.lesson2.classes.Car;
import com.epam.alexander_krivonozhkin.java.lesson2.classes.PassengerCar;
import com.epam.alexander_krivonozhkin.java.lesson3.Lesson3;

import java.util.Comparator;
import java.util.Date;

public class Main {

    public static void main(String[] args) {
//        Lesson1 lesson1 = new Lesson1();
//        lesson1.runTask1();
//        lesson1.runTask2();
//        lesson1.runTask3();

        Lesson2 lesson2 = new Lesson2();
        lesson2.runTask();

//        Lesson3 lesson3 = new Lesson3();
//        lesson3.runTask(false);

//        Car car1 = null, car2 = null, car3 = null;
//        try {
//            car1 = new PassengerCar("Lada", "Kalina", 500000, 7, 3);
//            car2 = new PassengerCar("Lada", "Kalina Sport", 550000, 6.5, 3);
//            car3 = new PassengerCar("ГАЗ", "3302", 900000, 14, 12);
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//        }
//
//        reList reList = new reList();
//        reList.add(car1);
//        reList.add(car2);
//        reList.add(car3);
//        for (Car car : reList.filter(x -> x.getBrand() == "Lada")) { System.out.println(car); }
//        System.out.println(reList.findFirst(x -> x.getBrand() == "Lada"));
//        reList sorted = reList.sorted(Comparator.comparingDouble(Car::getFuelConsumption));
//        for (Car car : sorted) { System.out.println(car); }
    }

}
