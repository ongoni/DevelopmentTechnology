package com.epam.alexander_krivonozhkin.java.collections;

public class reList<E> {
    private static final int default_capacity = 10;
    private Object entries[];
    private int size = 0;

    public reList() {
        entries = new Object[default_capacity];
    }

    public void add(E item) {
        if (entries.length == size) double_capacity();
        entries[size++] = item;
    }

    @SuppressWarnings("unchecked")
    public E get(int index) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        return (E) entries[index];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    private void double_capacity() {
        size = entries.length * 2;
    }

}
