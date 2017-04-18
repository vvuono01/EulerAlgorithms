package com.example;

import java.util.ArrayList;
import java.util.List;

public class Euler24 {
    private static final int NUM_PERMUTATION = 1000000;
    private static final int[] DIGITS = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};

    public static void main(String[] args) {
        long startMillis = System.currentTimeMillis();
        System.out.println(nthLexicographicPermutation(NUM_PERMUTATION, DIGITS.clone()));
        long endMillis = System.currentTimeMillis();
        System.out.println("Solved in " + (endMillis - startMillis) + " ms");
    }

    private static String nthLexicographicPermutation(int numPerm, int[] digits) {
        int count = 1;
        while (count < numPerm) {
            int n = digits.length;
            int i = n-1;
            while (digits[i-1] >= digits[i]) {
                i = i - 1;
            }

            int j = n;
            while (digits[j - 1] <= digits[i-1]) {
                j = j - 1;
            }

            swap(digits, i-1, j-1);

            i++;
            j = n;
            while (i < j) {
                swap(digits, i-1, j-1);
                i++;
                j--;
            }
            count++;
        }

        String permNum = "";
        for (int k = 0; k < digits.length; k++) {
            permNum = permNum + digits[k];
        }

        return permNum;
    }

    private static void swap(int[] digits, int i, int j) {
        int k = digits[i];
        digits[i] = digits[j];
        digits[j] = k;
    }
}
