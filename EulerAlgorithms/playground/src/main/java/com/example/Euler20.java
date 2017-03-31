package com.example;

import java.math.BigInteger;

public class Euler20 {
    public static void main(String[] args) {
        long startMillis = System.currentTimeMillis();
        System.out.println(sumOfDigitsOfFactorial(100));
        long endMillis = System.currentTimeMillis();
        System.out.println("Solved in " + (endMillis - startMillis) + " ms");
    }

    private static BigInteger sumOfDigitsOfFactorial(int n) {
        BigInteger value = factorial(n);
        BigInteger sum = BigInteger.ZERO;
        while (value.compareTo(BigInteger.ZERO) == 1) {
            sum = sum.add(value.mod(BigInteger.TEN));
            value = value.divide(BigInteger.TEN);
        }

        return sum;
    }

    private static BigInteger factorial(int n) {
        BigInteger ret = BigInteger.valueOf(2);
        for (int i = 3; i <= n; i++) {
            ret = ret.multiply(BigInteger.valueOf(i));
        }

        return ret;
    }
}
