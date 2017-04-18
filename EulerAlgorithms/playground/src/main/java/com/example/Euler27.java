package com.example;

import java.util.HashMap;
import java.util.Map;

public class Euler27 {
    private static final int LIMIT = 1000;

    public static void main(String[] args) {
        long startMillis = System.currentTimeMillis();
        System.out.println(productOfCoefficientsThatLeadToMaxNumberOfPrimes(LIMIT));
        long endMillis = System.currentTimeMillis();
        System.out.println("Solved in " + (endMillis - startMillis) + " ms");
    }

    private static int productOfCoefficientsThatLeadToMaxNumberOfPrimes(int limit) {
        int bestA = 0;
        int bestB = 0;
        int bestNumPrimes = 0;
        for (int a = -limit + 1; a < limit; a++) {
            for (int b = -limit + 1; b <= limit; b += 2) {
                int n = 0;
                while (isPrime(Math.abs(result(n, a, b)))) {
                    n++;
                }

                if (n > bestNumPrimes) {
                    bestA = a;
                    bestB = b;
                    bestNumPrimes = n;
                }
            }
        }

        return bestA * bestB;
    }

    private static int result(int n, int a, int b) {
        return (n * n) + (a * n) + b;
    }

    private static boolean isPrime(int n) {
        if (n > 1 && n <= 3) {
            return true;
        } else if (n % 2 == 0 || n % 3 == 0) {
            return false;
        }

        for (int i = 5; (i * i) <= n; i += 6) {
            if (n % i == 0 || n % (i + 2) == 0) {
                return false;
            }
        }
        return true;
    }
}