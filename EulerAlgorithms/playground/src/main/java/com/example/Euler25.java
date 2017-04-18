package com.example;

import java.math.BigInteger;

public class Euler25 {
    private static final int DIGITS = 1000;

    public static void main(String[] args) {
        long startMillis = System.currentTimeMillis();
        System.out.println(indexOfFirstFibonacciNumberWithDigits(DIGITS));
        long endMillis = System.currentTimeMillis();
        System.out.println("Solved in " + (endMillis - startMillis) + " ms");
    }

    private static int indexOfFirstFibonacciNumberWithDigits(int digits) {
        BigInteger previous = BigInteger.ONE;
        BigInteger current = BigInteger.ONE;
        int index = 2;
        while (String.valueOf(current).length() < digits) {
            BigInteger next = previous.add(current);
            previous = current;
            current = next;
            index++;
        }

        return index;
    }
}