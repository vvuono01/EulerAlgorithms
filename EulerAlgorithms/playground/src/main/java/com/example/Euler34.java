package com.example;

public class Euler34 {
    // https://en.wikipedia.org/wiki/Factorion#Upper_bound
    private static final int UPPER_BOUND = 1499999;

    public static void main(String[] args) {
        long startMillis = System.currentTimeMillis();
        System.out.println(sumOfAllFactorions());
        long endMillis = System.currentTimeMillis();
        System.out.println("Solved in " + (endMillis - startMillis) + " ms");
    }

    private static int sumOfAllFactorions() {
        int sum = 0;
        for (int i = 3; i < UPPER_BOUND; i++) {
            if (isFactorion(i)) {
                sum += i;
            }
        }

        return sum;
    }

    // This problem only cares about factorials up to 9! - therefore it can be an int
    private static int factorial(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }

        int ret = 2;
        for (int i = 3; i <= n; i++) {
            ret *= i;
        }

        return ret;
    }

    private static boolean isFactorion(int n) {
        int tracker = n;
        int sum = 0;
        while (tracker > 0) {
            int digit = tracker % 10;
            tracker = tracker / 10;

            sum += factorial(digit);
        }

        return sum == n;
    }
}