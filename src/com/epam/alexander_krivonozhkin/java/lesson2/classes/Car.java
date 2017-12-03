package com.epam.alexander_krivonozhkin.java.lesson2.classes;

import com.epam.alexander_krivonozhkin.java.lesson2.exceptions.EmptyStringException;
import com.epam.alexander_krivonozhkin.java.lesson2.exceptions.NegativeValueException;
import org.jetbrains.annotations.NotNull;

public abstract class Car implements Comparable<Car> {

    protected String brand;
    protected String model;
    protected double price;
    protected double fuelConsumption;

    public Car(String brand, String model, double price, double fuelConsumption) {
        try {
            this
                    .setBrand(brand)
                    .setModel(model)
                    .setPrice(price)
                    .setFuelConsumption(fuelConsumption);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public String getBrand() {
        return brand;
    }

    public Car setBrand(String brand) throws EmptyStringException {
        if (brand.length() == 0) throw new EmptyStringException();
        this.brand = brand;
        return this;
    }

    public String getModel() {
        return model;
    }

    public Car setModel(String model) throws EmptyStringException {
        if (model.length() == 0) throw new EmptyStringException();
        this.model = model;
        return this;
    }

    public double getPrice() {
        return price;
    }

    public Car setPrice(double price) throws NegativeValueException {
        if (price < 0) throw new NegativeValueException();
        this.price = price;
        return this;
    }

    public double getFuelConsumption() {
        return fuelConsumption;
    }

    public Car setFuelConsumption(double fuelConsumption) throws NegativeValueException {
        if (price < 0) throw new NegativeValueException();
        this.fuelConsumption = fuelConsumption;
        return this;
    }

    @Override
    public String toString() {
        return brand + " " + model + " - " + price + "\u20BD; " + fuelConsumption + " liters per 100km;";
    }

    @Override
    public int compareTo(@NotNull Car o) {
        return Double.compare(this.fuelConsumption, o.fuelConsumption);
    }
}
