package com.example;

import java.math.BigInteger;

public class Euler53 {
    public static void main(String[] args) {
        long startMillis = System.currentTimeMillis();
        System.out.println(combinatoricSelectionsGreaterThan(100, 1000000));
        long endMillis = System.currentTimeMillis();
        System.out.println("Solved in " + (endMillis - startMillis) + " ms");
    }

    private static long combinatoricSelectionsGreaterThan(int nLimit, int threshold) {
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
        return factorial(n).divide(factorial(r).multiply(factorial(n-r)));
    }

    private static BigInteger factorial(int n) {
        BigInteger ret = BigInteger.valueOf(1);
        for (int i = 2; i <= n; i++) {
            ret = ret.multiply(BigInteger.valueOf(i));
        }

        return ret;
    }
}
