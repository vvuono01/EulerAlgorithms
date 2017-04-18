package com.example;

public class Euler28 {
    public static void main(String[] args) {
        long startMillis = System.currentTimeMillis();
        System.out.println(sumOfNumbersOnDiagonalsOfSpiralOfSize(1001));
        long endMillis = System.currentTimeMillis();
        System.out.println("Solved in " + (endMillis - startMillis) + " ms");
    }

    private static int sumOfNumbersOnDiagonalsOfSpiralOfSize(int size) {
        int sum = 1;
        for (int i = 3; i <= size; i += 2) {
            int iSquared = (i*i);
            int iMinusOne = (i-1);

            sum += ((i-2) * (i-2)) + iMinusOne; // Lower right number
            sum += (iMinusOne * iMinusOne) + 1; // Lower left number
            sum += iSquared - iMinusOne;        // Upper left number
            sum += iSquared;                    // Upper right number
        }

        return sum;
    }
}