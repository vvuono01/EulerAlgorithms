package com.example;

public class Euler30 {
    private static int MAX_NUM_TO_CHECK = 354294;

    public static void main(String[] args) {
        long startMillis = System.currentTimeMillis();
        System.out.println(sumOfNumbersThatCanBeWrittenAsSumOfFifthPowersOfTheirDigits());
        long endMillis = System.currentTimeMillis();
        System.out.println("Solved in " + (endMillis - startMillis) + " ms");
    }

    private static int sumOfNumbersThatCanBeWrittenAsSumOfFifthPowersOfTheirDigits() {
        int sum = 0;
        for (int i = 2; i < MAX_NUM_TO_CHECK; i++) {
            int num = i;
            int digitSum = 0;
            while (num > 0 && digitSum <= i) {
                digitSum += Math.pow(num % 10, 5);
                num /= 10;
            }

            if (digitSum == i) {
                sum += digitSum;
            }
        }

        return sum;
    }
}