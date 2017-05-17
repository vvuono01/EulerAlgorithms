package com.example;

import java.math.BigInteger;

public class Euler48 {
    public static void main(String[] args) {
        long startMillis = System.currentTimeMillis();
        System.out.println(last10DigitsInSelfPowersSeries(1000));
        long endMillis = System.currentTimeMillis();
        System.out.println("Solved in " + (endMillis - startMillis) + " ms");
    }

    private static String last10DigitsInSelfPowersSeries(int limit) {
        BigInteger sum = BigInteger.ONE;
        for (int i = 2; i <= limit; i++) {
            sum = sum.add(BigInteger.valueOf(i).pow(i));
        }

        String sumString = sum.toString();
        return sumString.substring(sumString.length() - 10, sumString.length());
    }


}
