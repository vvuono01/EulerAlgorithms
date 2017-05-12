package com.example;

import java.util.ArrayList;
import java.util.List;

public class Euler33 {
    private static List<Integer> products = new ArrayList<>();

    public static void main(String[] args) {
        long startMillis = System.currentTimeMillis();
        System.out.println(denominatorOfCuriousFractions());
        long endMillis = System.currentTimeMillis();
        System.out.println("Solved in " + (endMillis - startMillis) + " ms");
    }

    private static long denominatorOfCuriousFractions() {
        int numeratorProduct = 1;
        int denominatorProduct = 1;

        for (int numerator = 11; numerator <= 99; numerator++) {
            int startDenominator = (10 * (numerator % 10)) + 1;
            for (int denominator = startDenominator; denominator < startDenominator + 9; denominator++) {
                if (isFractionCurious(numerator, denominator)) {
                    numeratorProduct *= numerator;
                    denominatorProduct *= denominator;
                }
            }
        }

        return denominatorProduct / numeratorProduct;
    }

    private static boolean isFractionCurious(int numerator, int denominator) {
        if (numerator >= denominator) {
            return false;
        }

        double fraction = (double) numerator / (double) denominator;
        double wrongFraction = ((double)(numerator / 10) / (double)(denominator % 10));
        return fraction == wrongFraction;
    }
}