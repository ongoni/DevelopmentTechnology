package com.epam.alexander_krivonozhkin.java.lesson2.serialization;

import com.epam.alexander_krivonozhkin.java.lesson2.classes.Car;
import com.epam.alexander_krivonozhkin.java.lesson2.classes.TaxiStation;
import com.epam.alexander_krivonozhkin.java.lesson2.utils.FileUtils;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.File;
import java.io.IOException;

public class Serializer {

    protected String path;

    public Serializer() {
        this.path = "data.json";
    }

    public Serializer(String path) {
        this.path = path;
    }

    public void serialize(TaxiStation station) throws IOException {
        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .registerTypeAdapter(Car.class, new CarAdapter())
                .create();

        new FileUtils().write(gson.toJson(station), new File(this.path));
    }

    public TaxiStation deserialize() {
        Gson gson = new GsonBuilder()
                .registerTypeAdapter(Car.class, new CarAdapter())
                .create();

        return gson.fromJson(
                new FileUtils().readAll(new File(this.path)),
                TaxiStation.class
        );
    }

}
