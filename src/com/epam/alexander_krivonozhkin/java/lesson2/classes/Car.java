package com.epam.alexander_krivonozhkin.java.lesson2.classes;

import org.jetbrains.annotations.NotNull;

public abstract class Car implements Comparable<Car> {

    protected String brand;
    protected String model;
    protected double price;
    protected double fuelConsumption;

    public Car(String brand, String model, double price, double fuelConsumption) {
        this
                .setBrand(brand)
                .setModel(model)
                .setPrice(price)
                .setFuelConsumption(fuelConsumption);
    }

    public String getBrand() {
        return brand;
    }

    public Car setBrand(String brand) {
        this.brand = brand;
        return this;
    }

    public String getModel() {
        return model;
    }

    public Car setModel(String model) {
        this.model = model;
        return this;
    }

    public double getPrice() {
        return price;
    }

    public Car setPrice(double price) {
        this.price = price;
        return this;
    }

    public double getFuelConsumption() {
        return fuelConsumption;
    }

    public Car setFuelConsumption(double fuelConsumption) {
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
