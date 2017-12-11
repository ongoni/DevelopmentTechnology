package com.epam.alexander_krivonozhkin.java.lesson2.exceptions;

public class EmptyStringException extends Exception {

    public EmptyStringException() {
        super("Empty string given");
    }

}
