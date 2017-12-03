package com.epam.alexander_krivonozhkin.java.lesson2.classes;

public class PassengerCar extends Car {

    protected int passengerSeatCount;

    public PassengerCar(String brand, String model, double price, double fuelConsumption, int passengerSeatCount) {
        super(brand, model, price, fuelConsumption);
        this.passengerSeatCount = passengerSeatCount;
    }

    public int getPassengerSeatCount() {
        return passengerSeatCount;
    }

    public Car setPassengerSeatCount(int passengerSeatCount) {
        this.passengerSeatCount = passengerSeatCount;
        return this;
    }

    @Override
    public String toString() {
        return super.toString() + " " + passengerSeatCount + " seats;";
    }

}
