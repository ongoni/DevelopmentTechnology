package com.epam.alexandr_krivonozhkin.java.lesson1.tas1;

import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Task {

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
        System.out.println(Math.abs(getMinimum(array) - getAverage(array)));
    }

    private List<String> fillList(Scanner in) {
        System.out.print("enter n: ");
        int n = in.nextInt();

        System.out.print("enter text: ");
        List<String> text = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            text.add(in.next());
        }

        return text;
    }

    public void Task2() {
        List<String> text = fillList(new Scanner(System.in));

        
    }

    public static void main(String[] args) {
        Task task = new Task();
        task.Task1();
    }
}
