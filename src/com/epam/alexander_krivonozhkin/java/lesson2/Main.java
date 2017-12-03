package com.epam.alexander_krivonozhkin.java.lesson2;

import com.epam.alexander_krivonozhkin.java.lesson2.classes.FreightCar;
import com.epam.alexander_krivonozhkin.java.lesson2.classes.PassengerCar;
import com.epam.alexander_krivonozhkin.java.lesson2.classes.TaxiStation;

public class Main {

    public static void main(String[] args) {
        TaxiStation station = new TaxiStation();
        PassengerCar passengerCar = new PassengerCar(
                "Lada",
                "Kalina",
                500000,
                7,
                3
        );
        PassengerCar passengerCar2 = new PassengerCar(
                "Lada",
                "Kalina Sport",
                550000,
                6.5,
                3
        );
        FreightCar freightCar = new FreightCar(
                "ГАЗ",
                "3302",
                900000,
                14,
                1.5
        );
        station.add(freightCar);
        station.add(passengerCar);
        station.add(passengerCar2);
//        station.show();
//        station.sorted(Comparator.naturalOrder()).show();
//        System.out.println(station.getFullPrice() + "\u20BD");
//        System.out.println(station.findOneBy(x -> x.getBrand() == "Lada" && x.getPrice() > 500000));
    }

}
