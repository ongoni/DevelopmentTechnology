package com.epam.alexander_krivonozhkin.java.collections;

import com.epam.alexander_krivonozhkin.java.lesson2.classes.Car;
import org.jetbrains.annotations.NotNull;

import java.util.*;
import java.util.function.Predicate;

@SuppressWarnings("unchecked")
public class reList implements Iterable<Car> {
    private static final int DEFAULT_CAPACITY = 10;
    private Car entries[];
    private int size = 0;

    public class reIterator<Car> implements Iterator<Car> {
        private int cursor;

        @Override
        public boolean hasNext() {
            return cursor < size;
        }

        @Override
        public Car next() {
            if (!hasNext()) throw new NoSuchElementException();
            return (Car) entries[cursor++];
        }
    }

    @NotNull
    @Override
    public Iterator<Car> iterator() {
        return new reIterator<>();
    }

    public reList() {
        entries = new Car[DEFAULT_CAPACITY];
    }

    public reList(reList list) {
        entries = list.entries;
    }

    private reList(Car[] cars) {
        entries = cars;
    }

    private void doubleCapacity() {
        int newCapacity = entries.length * 2;
        entries = Arrays.copyOf(entries, newCapacity);
    }

    public void add(Car item) {
        if (entries.length == size) doubleCapacity();
        entries[size++] = item;
    }

    public void addAll(Collection<Car> cars) {
        for (Car car : cars) this.add(car);
    }

    public Car get(int index) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        return entries[index];
    }

    public void set(int index, Car value) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        entries[index] = value;
    }

    public void clear() {
        Arrays.fill(entries, null);
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public reList filter(Predicate<Car> predicate) {
        reList result = new reList();
        for (int i = 0; i < size; i++) {
            if (predicate.test(entries[i])) {
                result.add(entries[i]);
            }
        }

        return result;
    }

    public Car findFirst(Predicate<Car> predicate) {
        for (int i = 0; i < size; i++) {
            if (predicate.test(entries[i])) {
                return entries[i];
            }
        }

        return null;
    }

    public reList sorted(Comparator<Car> comparator) {
        reList result = new reList(Arrays.copyOfRange(this.entries, 0, size));
        Arrays.sort(result.entries, comparator);
        result.size = size;

        return result;
    }

}
