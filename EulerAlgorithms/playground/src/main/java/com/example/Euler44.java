package com.example;

import java.util.ArrayList;
import java.util.List;

public class Euler44 {
    private static final int UPPER_BOUND = 10000;

    private static List<Integer> pentagonalNumbers = new ArrayList<>();

    public static void main(String[] args) {
        long startMillis = System.currentTimeMillis();
        System.out.println(smallestDifferenceBetweenPentagonalNumbers());
        long endMillis = System.currentTimeMillis();
        System.out.println("Solved in " + (endMillis - startMillis) + " ms");
    }

    private static int smallestDifferenceBetweenPentagonalNumbers() {
        for (int i = 1; i <= UPPER_BOUND; i++) {
            pentagonalNumbers.add(pentagonalNumber(i));
        }

        for (int j = 1; j <= UPPER_BOUND; j++) {
            int pj = pentagonalNumbers.get(j-1);
            for (int k = 1; k <= UPPER_BOUND; k++) {
                int pk = pentagonalNumbers.get(k-1);

                int diff = Math.abs(pj - pk);
                if (pentagonalNumbers.contains(pj + pk) &&
                    pentagonalNumbers.contains(diff)) {
                    return diff;
                }
            }
        }

        return 0;
    }

    private static int pentagonalNumber(int n) {
        return (n * ((3 * n) - 1)) / 2;
    }
}
