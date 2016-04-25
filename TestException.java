package com.venkat.exception;

public class TestException {
    public static void main(String[] args) {
        try {
        	int i = 1/0;
            throw new RuntimeException("Bang");
        } catch (Exception e) {
            System.out.println("I caught: " + e);
        }
    }
}