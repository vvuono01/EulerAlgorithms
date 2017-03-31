package com.example;

public class Euler10 {
    public static void main(String[] args) {
        long startMillis = System.currentTimeMillis();
        System.out.println(sumOfPrimesBelow(2000000));
        long endMillis = System.currentTimeMillis();
        System.out.println("Solved in " + (endMillis - startMillis) + " ms");
    }

    private static long sumOfPrimesBelow(int n) {
        long sum = 2 + 3;
        for (int i = 5; i < n; i += 6) {
            if (isPrime(i)) {
                sum += i;
            }

            if (isPrime(i + 2)) {
                sum += (i + 2);
            }
        }

        return sum;
    }

    private static boolean isPrime(int n) {
        if (n > 1 && n <= 3) {
            return true;
        } else if (n % 2 == 0 || n % 3 == 0) {
            return false;
        }

        for (int i = 5; (i * i) <= n; i += 6) {
            if (n % i == 0 || n % (i + 2) == 0) {
                return false;
            }
        }
        return true;
    }
}
