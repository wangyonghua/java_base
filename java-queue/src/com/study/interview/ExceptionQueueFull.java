package com.study.interview;

public class ExceptionQueueFull extends Exception {

    // Constructor
    public ExceptionQueueFull() {

    }

    // Constructor with parameters
    public ExceptionQueueFull(String mag) {
        System.out.println(mag);
    }
}