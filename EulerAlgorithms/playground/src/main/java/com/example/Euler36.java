package com.example;

public class Euler36 {

    public static void main(String[] args) {
        long startMillis = System.currentTimeMillis();
        System.out.println(sumOfPalindromesUnder(1000000));
        long endMillis = System.currentTimeMillis();
        System.out.println("Solved in " + (endMillis - startMillis) + " ms");
    }

    private static long sumOfPalindromesUnder(int n) {
        long sum = 0;
        for (int i = 1; i < n; i++) {
            if (isPalindrome(Integer.toString(i)) && isPalindrome(Integer.toBinaryString(i))) {
                sum += i;
            }
        }

        return sum;
    }

    private static boolean isPalindrome(String s) {
        int size = s.length();
        for (int i = 0; i < size / 2; i++) {
            if (s.charAt(i) != s.charAt(size - i - 1)) {
                return false;
            }
        }

        return true;
    }
}
