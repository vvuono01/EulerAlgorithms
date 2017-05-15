package com.example;

import java.util.ArrayList;
import java.util.List;

public class Euler41 {
    // Take the digit sum of the pandigital numbers; all except 4-pandigital and 7-pandigital numbers can be divided by 3, and therefore can't be prime
    // http://www.mathblog.dk/project-euler-41-pandigital-prime/
    private static int UPPER_BOUND = 7654321;

    public static void main(String[] args) {
        long startMillis = System.currentTimeMillis();
        System.out.println(largestPandigitalPrime());
        long endMillis = System.currentTimeMillis();
        System.out.println("Solved in " + (endMillis - startMillis) + " ms");
    }

    private static long largestPandigitalPrime() {
        for (int i = UPPER_BOUND; i >= 0; i -= 2) {
            if (isPrime(i) && is1toNPandigital(i, String.valueOf(i).length())) {
                return i;
            }
        }

        return 0;
    }

    private static boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        } else if (n > 1 && n <= 3) {
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

    private static boolean is1toNPandigital(long value, int n) {
        if (Long.toString(value).length() != n) {
            return false;
        }

        List<Integer> digits = new ArrayList<>();
        long tracker = value;
        while (tracker > 0) {
            int digit = (int) tracker % 10;

            if (digit == 0 || digit > n || digits.contains(digit)) {
                return false;
            }

            digits.add(digit);
            tracker /= 10;
        }

        if (digits.size() == n) {
            return true;
        }

        return false;
    }
}
