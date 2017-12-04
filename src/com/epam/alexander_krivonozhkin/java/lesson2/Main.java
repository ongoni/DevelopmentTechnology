package com.epam.alexander_krivonozhkin.java.lesson2;

import com.epam.alexander_krivonozhkin.java.lesson2.classes.TaxiStation;
import com.epam.alexander_krivonozhkin.java.lesson2.serialization.Serializer;
import com.epam.alexander_krivonozhkin.java.lesson2.utils.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.Comparator;

public class Main {

    public static void main(String[] args) {
        TaxiStation station = new TaxiStation();
        Serializer serializer = new Serializer();

        station.addAll(new FileUtils().readCarsFrom(new File("./cars.txt")));
        station.show();
        System.out.println();

        try {
            serializer.serialize(station);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        serializer.deserialize().show();
        System.out.println();

        station.sorted(Comparator.naturalOrder()).show();
        System.out.println();

        System.out.println("full price - " + station.getFullPrice() + "\u20BD");
        System.out.println(station.findOneBy(x -> x.getBrand().equals("Lada") && x.getPrice() > 500000));
    }

}
