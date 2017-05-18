package com.example;

import java.math.BigInteger;

public class Euler53 {
    private static BigInteger[] factorials = new BigInteger[101];

    public static void main(String[] args) {
        long startMillis = System.currentTimeMillis();
        System.out.println(combinatoricSelectionsGreaterThan(100, 1000000));
        long endMillis = System.currentTimeMillis();
        System.out.println("Solved in " + (endMillis - startMillis) + " ms");
    }

    private static long combinatoricSelectionsGreaterThan(int nLimit, int threshold) {
        factorials[0] = BigInteger.ONE;
        for (int i = 1; i <= nLimit; i++) {
            factorials[i] = factorials[i-1].multiply(BigInteger.valueOf(i));
        }

        int count = 0;
        for (int n = 23; n <= nLimit; n++) {
            for (int r = 0; r <= n; r++) {
                if (nChooseR(n, r).compareTo(BigInteger.valueOf(threshold)) > 0) {
                    count++;
                }
            }
        }

        return count;
    }

    private static BigInteger nChooseR(int n, int r) {
        return factorials[n].divide(factorials[r].multiply(factorials[n-r]));
    }
}
