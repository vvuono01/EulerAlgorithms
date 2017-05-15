package com.example;

public class Euler39 {
    public static void main(String[] args) {
        long startMillis = System.currentTimeMillis();
        System.out.println(rightTrianglePerimeterWithLargestNumberOfSolutions(1000));
        long endMillis = System.currentTimeMillis();
        System.out.println("Solved in " + (endMillis - startMillis) + " ms");
    }

    private static int rightTrianglePerimeterWithLargestNumberOfSolutions(int upperLimit) {
        int p = 1;
        int numSolutionsForP = numSolutionsForP(p);
        for (int i = 2; i < upperLimit; i++) {
            int currentSolutions = numSolutionsForP(i);
            if (currentSolutions > numSolutionsForP) {
                p = i;
                numSolutionsForP = currentSolutions;
            }
        }
        return p;
    }

    private static int numSolutionsForP(int p) {
        int numSolutions = 0;
        for (int c = p/3; c < p/2; c++) {
            for (int b = (p-c) / 2; b < c; b++) {
                int a = p-c-b;
                if (Math.pow(a, 2) + Math.pow(b, 2) == Math.pow(c, 2)) {
                    numSolutions++;
                }
            }
        }

        return numSolutions;
    }
}
