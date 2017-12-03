package com.epam.alexander_krivonozhkin.java.lesson2;

import com.epam.alexander_krivonozhkin.java.lesson2.classes.Car;
import com.epam.alexander_krivonozhkin.java.lesson2.classes.FreightCar;
import com.epam.alexander_krivonozhkin.java.lesson2.classes.PassengerCar;
import com.epam.alexander_krivonozhkin.java.lesson2.classes.TaxiStation;

public class Main {

    public static void main(String[] args) {
        TaxiStation station = new TaxiStation();
        Car passengerCar1 = null, passengerCar2 = null, freightCar = null;
        try {
            passengerCar1 = new PassengerCar(
                    "Lada",
                    "Kalina",
                    500000,
                    7,
                    3
            );
            passengerCar2 = new PassengerCar(
                    "Lada",
                    "Kalina Sport",
                    550000,
                    6.5,
                    3
            );
            freightCar = new FreightCar(
                    "ГАЗ",
                    "3302",
                    900000,
                    14,
                    1.5
            );
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        station.add(freightCar);
        station.add(passengerCar1);
        station.add(passengerCar2);
//        station.show();
//        station.sorted(Comparator.naturalOrder()).show();
//        System.out.println(station.getFullPrice() + "\u20BD");
//        System.out.println(station.findOneBy(x -> x.getBrand() == "Lada" && x.getPrice() > 500000));
    }

}
