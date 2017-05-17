package com.example;

public class Euler49 {
    private static int LOWER_BOUND = 1489;
    private static int UPPER_BOUND = 3339;

    public static void main(String[] args) {
        long startMillis = System.currentTimeMillis();
        System.out.println(sequenceWhereMembersArePrimeAndPermutations());
        long endMillis = System.currentTimeMillis();
        System.out.println("Solved in " + (endMillis - startMillis) + " ms");
    }

    private static String sequenceWhereMembersArePrimeAndPermutations() {
        for (int i = LOWER_BOUND; i <= UPPER_BOUND; i++) {
            if (isPrime(i)) {
                int second = i + 3330;
                if (isPrime(second) && isPermutation(String.valueOf(second), String.valueOf(i))) {
                    int third = i + 6660;
                    if (isPrime(third) && isPermutation(String.valueOf(third), String.valueOf(i))) {
                        return i + "" + second + "" + third;
                    }
                }
            }
        }
        return "";
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

    private static boolean isPermutation(String perm, String orig) {
        if (perm.length() != orig.length()) {
            return false;
        }

        for (int i = 0; i < orig.length(); i++) {
            if (!perm.contains(String.valueOf(orig.charAt(i)))) {
                return false;
            }
        }

        return true;
    }
}
