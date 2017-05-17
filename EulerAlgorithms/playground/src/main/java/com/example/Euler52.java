package com.example;

public class Euler52 {
    public static void main(String[] args) {
        long startMillis = System.currentTimeMillis();
        System.out.println(sequenceWhereMembersArePrimeAndPermutations());
        long endMillis = System.currentTimeMillis();
        System.out.println("Solved in " + (endMillis - startMillis) + " ms");
    }

    private static long sequenceWhereMembersArePrimeAndPermutations() {
        int num = 123456;
        while (true) {
            String numString = String.valueOf(num);
            if (isPermutation(String.valueOf(num * 2), numString) &&
                isPermutation(String.valueOf(num * 3), numString) &&
                isPermutation(String.valueOf(num * 4), numString) &&
                isPermutation(String.valueOf(num * 5), numString) &&
                isPermutation(String.valueOf(num * 6), numString)) {
                return num;
            }

            num++;
        }
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
