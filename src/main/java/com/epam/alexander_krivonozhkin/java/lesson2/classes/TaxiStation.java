package com.epam.alexander_krivonozhkin.java.lesson2.classes;

import com.epam.alexander_krivonozhkin.java.collections.reList;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class TaxiStation {

    protected reList carPool;

    public TaxiStation() {
        this.carPool = new reList();
    }

    public TaxiStation(TaxiStation station) {
        this.carPool = new reList(station.carPool);
    }

    public TaxiStation(reList carPool) {
        this.carPool = carPool;
    }

    public void add(Car car) {
        this.carPool.add(car);
    }

    public void addAll(Collection<Car> cars) {
        this.carPool.addAll(cars);
    }

    public void clear() {
        this.carPool.clear();
    }

    public void show() {
        for (Car car: this.carPool) {
            System.out.println(car);
        }
    }

    public TaxiStation sorted(Comparator<Car> comparator) {
        return new TaxiStation(carPool.sorted(comparator));
    }

    public double getFullPrice() {
        double result = 0.0;
        for (Car car : carPool) result += car.price;

        return result;
    }

    public Car findOneBy(Predicate<Car> predicate) {
        return carPool.findFirst(predicate);
    }

    public reList findAll(Predicate<Car> predicate) {
        return carPool.filter(predicate);
    }

}
