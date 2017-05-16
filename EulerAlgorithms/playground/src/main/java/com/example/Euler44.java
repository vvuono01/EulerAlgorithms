package com.example;

public class Euler44 {
    public static void main(String[] args) {
        long startMillis = System.currentTimeMillis();
        System.out.println(smallestDifferenceBetweenPentagonalNumbers());
        long endMillis = System.currentTimeMillis();
        System.out.println("Solved in " + (endMillis - startMillis) + " ms");
    }

    private static int smallestDifferenceBetweenPentagonalNumbers() {
        int j = 1;
        while (true) {
            j++;
            int pj = pentagonalNumber(j);
            for (int k = j - 1; k >= 1; k--) {
                int pk = pentagonalNumber(k);

                int diff = pj - pk;
                if (isPentagonal(pj + pk) &&
                    isPentagonal(diff)) {
                    return diff;
                }
            }
        }
    }

    private static int pentagonalNumber(int n) {
        return (n * ((3 * n) - 1)) / 2;
    }

    private static boolean isPentagonal(int n) {
        double number = (Math.sqrt((24.0 * n) + 1.0) + 1.0) / 6.0;
        return number == (int) number;
    }
}
