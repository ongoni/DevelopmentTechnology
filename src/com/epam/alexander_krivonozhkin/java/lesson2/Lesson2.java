package com.epam.alexander_krivonozhkin.java.lesson2;

import com.epam.alexander_krivonozhkin.java.lesson2.classes.TaxiStation;
import com.epam.alexander_krivonozhkin.java.lesson2.serialization.Serializer;
import com.epam.alexander_krivonozhkin.java.lesson2.utils.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.Comparator;

public class Lesson2 {

    public void runTask() {
        TaxiStation station = new TaxiStation();
        Serializer serializer = new Serializer();
        FileUtils utils = new FileUtils();

        System.out.println("source:");
        station.addAll(utils.readCarsFrom(new File("./cars.txt")));
        station.show();

        try {
            serializer.serialize(station);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        System.out.println("deserialized:");
        serializer.deserialize().show();

        System.out.println("sorted:");
        station.sorted(Comparator.naturalOrder()).show();

        System.out.println("full price - " + station.getFullPrice() + "\u20BD");
        System.out.println("found by criteria - " + station.findOneBy(x -> x.getBrand().equals("Lada") && x.getPrice() > 500000));
    }

}
