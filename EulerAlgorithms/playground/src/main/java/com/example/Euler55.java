package com.example;

import java.math.BigInteger;

public class Euler55 {
    public static void main(String[] args) {
        long startMillis = System.currentTimeMillis();
        System.out.println(lychrelNumbersBelow(10000));
        long endMillis = System.currentTimeMillis();
        System.out.println("Solved in " + (endMillis - startMillis) + " ms");
    }

    private static long lychrelNumbersBelow(int limit) {
        int count = 0;
        for (int i = 10; i < limit; i++) {
            if (isLychrelNumber(i)) {
                count++;
            }
        }
        return count;
    }

    private static boolean isLychrelNumber(int n) {
        BigInteger num = BigInteger.valueOf(n);
        for (int i = 1; i < 25; i++) {
            String reverseNumString = new StringBuilder(num.toString()).reverse().toString();
            BigInteger reverseNum = BigInteger.valueOf(Long.parseLong(reverseNumString));
            num = num.add(reverseNum);
            if (isPalindrome(num.toString())) {
                return false;
            }
        }

        return true;
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
