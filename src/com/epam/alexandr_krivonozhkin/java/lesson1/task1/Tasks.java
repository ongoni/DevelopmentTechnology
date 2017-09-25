package com.epam.alexandr_krivonozhkin.java.lesson1.task1;

import java.util.*;
import java.util.function.BinaryOperator;

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
            if (item < min) {
                min = item;
            }
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

    public void task1() {
        System.out.println("task 1:");
        int[] array = getFilledArray(20);
        print(array);
        System.out.println();
        System.out.println(Math.abs(getMinimum(array)) - Math.abs(getAverage(array)));
    }

    private List<String> getFilledList(int n, Scanner in) {
        System.out.print("enter text: ");
        List<String> text = new ArrayList<>();

        int i = 0;
        while (i++ < n) {
            text.add(in.next());
        }

        return text;
    }

    private String getElementWithUniqueSymbols(List<String> words) {
        return words.stream()
                .filter(this::containsUniqueElements)
                .findFirst()
                .orElse("");
    }

    private boolean containsUniqueElements(String word) {
        for (int i = 0; i < word.length(); i++) {
            if (word.lastIndexOf(word.charAt(i)) != i) {
                return false;
            }
        }
        return true;
    }

    public void task2() {
        System.out.println("task 2:");
        Scanner in = new Scanner(System.in);
        System.out.print("enter n: ");
        int n = in.nextInt();
        in.nextLine();

        System.out.println(
                getElementWithUniqueSymbols(getFilledList(n, in))
        );
    }

    private double calculate(double a, double b, BinaryOperator<Double> operator) {
        return operator.apply(a, b);
    }

    public void task3() {
        System.out.println("task 3:");
        Scanner in = new Scanner(System.in);

        while (true) {
            System.out.print("enter a: ");
            int a = in.nextInt();
            System.out.print("enter b: ");
            int b = in.nextInt();
            System.out.print("enter operation (+, -, *, /): ");

            double result = 0;
            switch (in.next().charAt(0)) {
                case '+':
                    result = calculate(a, b, (x, y) -> x + y);
                    break;
                case '-':
                    result = calculate(a, b, (x, y) -> x - y);
                    break;
                case '*':
                    result = calculate(a, b, (x, y) -> x * y);
                    break;
                case '/':
                    result = calculate(a, b, (x, y) -> x / y);
                    break;
                default:
                    break;
            }

            System.out.println(result);
        }
    }

    public static void main(String[] args) {
        System.out.println("java:");
        Tasks tasks = new Tasks();
        tasks.task1();
        tasks.task2();
        tasks.task3();
        System.out.println("kotlin:");
        TasksKt tasksKt = new TasksKt();
        tasksKt.task1();
        tasksKt.task2();
        tasksKt.task3();
    }

}
