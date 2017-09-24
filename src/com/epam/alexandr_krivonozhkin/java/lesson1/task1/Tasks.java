package com.epam.alexandr_krivonozhkin.java.lesson1.task1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Tasks {

    private int[] getFilledArray(int length) {
        int[] array = new int[length];
        for (int i = 0; i < length; i++) {
            array[i] = -10 + (int)(Math.random() * 20);
        }
        return array;
    }

    private int getMinimum(int[] array) {
        int min = array[0];
        for (int item : array) {
            if (item < min) min = item;
        }
        return min;
    }

    private double getAverage(int[] array) {
        double sum = 0;
        for (int item : array) {
            sum += item;
        }
        return sum / array.length;
    }

    private void print(int[] array) {
        for (int item : array) {
            System.out.print(item + " ");
        }
    }

    public void Task1() {
        int[] array = getFilledArray(20);
        print(array);
        System.out.println();
//        System.out.println(Math.abs(getMinimum(array) - getAverage(array)));
        System.out.println(getMinimum(array) - getAverage(array));
    }

    private String getElementWithUniqueSymbols() {
        Scanner in = new Scanner(System.in);
        System.out.print("enter n: ");
        int n = in.nextInt();

        System.out.print("enter text: ");
        return Arrays.asList(in.nextLine().split(" ")).subList(0, n)
                .stream()
                .filter(this::containsUniqueElements)
                .findFirst()
                .get();
    }

    private boolean containsUniqueElements(String word) {
        for (int i = 0; i < word.length(); i++) {
            if (word.lastIndexOf(word.charAt(i)) != i) {
                return false;
            }
        }
        return true;
    }

    public void Task2() {
        System.out.println(getElementWithUniqueSymbols());
    }

    public static void main(String[] args) {
        Tasks tasks = new Tasks();
//        tasks.Task1();
        tasks.Task2();
    }

}
