package com.example;

import java.util.ArrayList;
import java.util.List;

public class Euler38 {
    public static void main(String[] args) {
        long startMillis = System.currentTimeMillis();
        System.out.println(largestPandigitalConcatenatedProduct());
        long endMillis = System.currentTimeMillis();
        System.out.println("Solved in " + (endMillis - startMillis) + " ms");
    }

    private static long largestPandigitalConcatenatedProduct() {
        long num = 0;
        for (int i = 0; i < 10000; i++) {
            for (int j = 2; j <= 9; j++) {
                long product = concatenatedProduct(i, j);
                if (product > num && isPandigital(product)) {
                    num = product;
                }
            }
        }
        return num;
    }

    private static long concatenatedProduct(int integer, int n) {
        String concatenation = "";
        for (int i = 1; i <= n; i++) {
            concatenation += Integer.toString(integer * i);
            if (concatenation.length() > 9) {
                break;
            }
        }

        return Long.parseLong(concatenation);
    }

    private static boolean isPandigital(long value) {
        List<Integer> digits = new ArrayList<>();
        long tracker = value;
        while (tracker > 0) {
            int digit = (int) tracker % 10;

            if (digit == 0 || digits.contains(digit)) {
                return false;
            }

            digits.add(digit);
            tracker /= 10;
        }

        if (digits.size() == 9) {
            return true;
        }

        return false;
    }
}
