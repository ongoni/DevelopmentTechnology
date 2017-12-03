package com.epam.alexander_krivonozhkin.java.lesson2.classes;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class TaxiStation {

    protected List<Car> carPool;

    public TaxiStation() {
        this.carPool = new ArrayList<>();
    }

    public TaxiStation(TaxiStation station) {
        this.carPool = new ArrayList<>(station.carPool);
    }

    public TaxiStation(List<Car> carPool) {
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
        return new TaxiStation(
                this.carPool.stream()
                        .sorted(comparator)
                        .collect(Collectors.toList())
        );
    }

    public double getFullPrice() {
        return this.carPool.stream()
                .reduce(
                        0.0,
                        (sum, car) -> sum += car.price,
                        (sum1, sum2) -> sum1 + sum2
                );
    }

    public Car findOneBy(Predicate<Car> predicate) {
        return this.carPool.stream()
                .filter(predicate)
                .findFirst()
                .orElse(null);
    }

    public List<Car> findAll(Predicate<Car> predicate) {
        return this.carPool.stream()
                .filter(predicate)
                .collect(Collectors.toList());
    }

}
