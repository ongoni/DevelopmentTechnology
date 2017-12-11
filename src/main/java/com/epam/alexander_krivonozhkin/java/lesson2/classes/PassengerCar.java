package com.epam.alexander_krivonozhkin.java.lesson2.classes;

import com.epam.alexander_krivonozhkin.java.lesson2.exceptions.NegativeValueException;

public class PassengerCar extends Car {

    protected int passengerSeatCount;

    public PassengerCar(String brand, String model, double price, double fuelConsumption, int passengerSeatCount)
            throws NegativeValueException {
        super(brand, model, price, fuelConsumption);
        this.setPassengerSeatCount(passengerSeatCount);
    }

    public int getPassengerSeatCount() {
        return passengerSeatCount;
    }

    public Car setPassengerSeatCount(int passengerSeatCount) throws NegativeValueException {
        if (passengerSeatCount < 0) throw new NegativeValueException();
        this.passengerSeatCount = passengerSeatCount;
        return this;
    }

    @Override
    public String toString() {
        return super.toString() + " " + passengerSeatCount + " seats;";
    }

}
