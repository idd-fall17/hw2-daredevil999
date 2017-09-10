package com.example.androidthings.myproject;

/**
 * Created by KiANMiNG on 8/9/2017.
 */

public class IllegalValueException extends Exception {
    /**
     * @param message should contain relevant information on the failed constraint(s)
     */
    public IllegalValueException(String message) {
        super(message);
    }
}
