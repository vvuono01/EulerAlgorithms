package com.example;

public class Euler31 {
    private static int[] currencies = {1, 2, 5, 10, 50, 100, 200};

    public static void main(String[] args) {
        long startMillis = System.currentTimeMillis();
        System.out.println(numCombinationsToMake2Pounds());
        long endMillis = System.currentTimeMillis();
        System.out.println("Solved in " + (endMillis - startMillis) + " ms");
    }

    private static int numCombinationsToMake2Pounds() {
        int target  = 200;
        int ways = 0;

        for (int a = target; a >= 0; a -= 200) {
            for (int b = a; b >= 0; b -= 100) {
                for (int c = b; c >= 0; c -= 50) {
                    for (int d = c; d >= 0; d -= 20) {
                        for (int e = d; e >= 0; e -= 10) {
                            for (int f = e; f >= 0; f -= 5) {
                                for (int g = f; g >= 0; g -= 2) {
                                    ways++;
                                }
                            }
                        }
                    }
                }
            }
        }

        return ways;
    }
}