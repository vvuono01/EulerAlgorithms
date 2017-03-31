package com.example;

import java.math.BigInteger;

public class Euler15 {
    public static void main(String[] args) {
        long startMillis = System.currentTimeMillis();
        System.out.println(numberOfPathsThroughGridOfSize(20));
        long endMillis = System.currentTimeMillis();
        System.out.println("Solved in " + (endMillis - startMillis) + " ms");
    }

    private static BigInteger numberOfPathsThroughGridOfSize(int gridSize) {
        int pathLength = gridSize * 2;
        return partialFactorial(pathLength, gridSize + 1).divide(factorial(gridSize));
    }

    private static BigInteger factorial(int n) {
        return partialFactorial(n, 1);
    }

    private static BigInteger partialFactorial(int n, int start) {
        BigInteger ret = BigInteger.valueOf(start);
        for (int i = start + 1; i <= n; i++) {
            ret = ret.multiply(BigInteger.valueOf(i));
        }

        return ret;
    }
}
