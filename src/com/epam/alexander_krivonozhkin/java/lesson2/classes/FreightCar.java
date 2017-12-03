package com.epam.alexander_krivonozhkin.java.lesson2.classes;

public class FreightCar extends Car {

    protected double tonnage;

    public FreightCar(String brand, String model, double price, double fuelConsumption, double tonnage) {
        super(brand, model, price, fuelConsumption);
        this.tonnage = tonnage;
    }

    public double getTonnage() {
        return tonnage;
    }

    public Car setTonnage(double tonnage) {
        this.tonnage = tonnage;
        return this;
    }

    @Override
    public String toString() {
        return super.toString() + " " + tonnage + " tons;";
    }

}
