package com.epam.alexander_krivonozhkin.java.lesson2.classes;

import com.epam.alexander_krivonozhkin.java.lesson2.exceptions.NegativeValueException;

public class FreightCar extends Car {

    protected double tonnage;

    public FreightCar(String brand, String model, double price, double fuelConsumption, double tonnage)
            throws NegativeValueException {
        super(brand, model, price, fuelConsumption);
        this.setTonnage(tonnage);
    }

    public double getTonnage() {
        return tonnage;
    }

    public Car setTonnage(double tonnage) throws NegativeValueException {
        if (tonnage < 0) throw new NegativeValueException();
        this.tonnage = tonnage;
        return this;
    }

    @Override
    public String toString() {
        return super.toString() + " " + tonnage + " tons;";
    }

}
