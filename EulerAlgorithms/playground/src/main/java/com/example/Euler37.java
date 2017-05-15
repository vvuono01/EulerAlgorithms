package com.example;

public class Euler37 {
    // https://en.wikipedia.org/wiki/Truncatable_prime
    private static final long UPPER_BOUND = 73939133;

    public static void main(String[] args) {
        long startMillis = System.currentTimeMillis();
        System.out.println(sumOfTruncatablePrimes());
        long endMillis = System.currentTimeMillis();
        System.out.println("Solved in " + (endMillis - startMillis) + " ms");
    }

    private static long sumOfTruncatablePrimes() {
        long sum = 0;
        for (int i = 11; i <= UPPER_BOUND; i += 6) {
            if (isPrimeTruncatable(i)) {
                sum += i;
            }

            if (isPrimeTruncatable(i + 2)) {
                sum += i + 2;
            }
        }

        return sum;
    }

    private static boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        } else if (n > 1 && n <= 3) {
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

    private static boolean isPrimeTruncatable(int n) {
        String nString = Integer.toString(n);
        if (nString.contains("0") || (nString.contains("2") && !nString.startsWith("2")) || (nString.contains("5") && !nString.startsWith("5"))) {
            return false;
        }

        if (!isPrime(n)) {
            return false;
        }

        String leftToRightStr = "";
        String rightToLeftStr = "";

        for (int i = 1; i < nString.length(); i++) {
            int leftToRight = Integer.parseInt(nString.substring(i, nString.length()));
            int rightToLeft = Integer.parseInt(nString.substring(0, nString.length() - i));

            leftToRightStr += " " + leftToRight;
            rightToLeftStr += " " + rightToLeft;

            if (!isPrime(leftToRight) || !isPrime(rightToLeft)) {
                return false;
            }
        }

        System.out.println(n + "; left to right:" + leftToRightStr + "; right to left:" + rightToLeftStr);
        return true;
    }
}
