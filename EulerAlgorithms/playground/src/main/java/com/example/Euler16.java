package com.example;

import java.math.BigInteger;

public class Euler16 {
    public static void main(String[] args) {
        System.out.println(sumOfDigitsOfPowerOf2(1000));
    }

    private static int sumOfDigitsOfPowerOf2(int power) {
        BigInteger value = BigInteger.valueOf(2).pow(power);
        int sum = 0;
        while (value.compareTo(BigInteger.ZERO) == 1) {         // while (value > 0)
            sum = sum + value.mod(BigInteger.TEN).intValue();
            value = value.divide(BigInteger.TEN);
        }

        return sum;
    }
}
