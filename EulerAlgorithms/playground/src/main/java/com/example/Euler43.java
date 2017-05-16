package com.example;

public class Euler43 {
    private static int[] divisors = {0, 1, 2, 3, 5, 7, 11, 13, 17};

    public static void main(String[] args) {
        long startMillis = System.currentTimeMillis();
        System.out.println(sumOfSubstringDivisibilityPandigitalNumbers());
        long endMillis = System.currentTimeMillis();
        System.out.println("Solved in " + (endMillis - startMillis) + " ms");
    }

    private static long sumOfSubstringDivisibilityPandigitalNumbers() {
        // http://www.mathblog.dk/project-euler-43-pandigital-numbers-sub-string-divisibility/
        long sum = 0;
        for (int d1 = 1; d1 <= 9; d1++) {
        for (int d2 = 0; d2 <= 9; d2++) {
        for (int d3 = 0; d3 <= 9; d3++) {
        for (int d4 = 0; d4 <= 9; d4 += 2) {
        for (int d5 = 0; d5 <= 9; d5 += 3) {
        int d6 = 5;
        for (int d7 = 0; d7 <= 9; d7++) {
        for (int d8 = 0; d8 <= 9; d8++) {
        for (int d9 = 0; d9 <= 9; d9++) {
        for (int d10 = 0; d10 <= 9; d10++) {
            if (!(d1 == d2 || d1 == d3 || d1 == d4 || d1 == d5 || d1 == d6 || d1 == d7 || d1 == d8 || d1 == d9 || d1 == d10 ||
                  d2 == d3 || d2 == d4 || d2 == d5 || d2 == d6 || d2 == d7 || d2 == d8 || d2 == d9 || d2 == d10 ||
                  d3 == d4 || d3 == d5 || d3 == d6 || d3 == d7 || d3 == d8 || d3 == d9 || d3 == d10 ||
                  d4 == d5 || d4 == d6 || d4 == d7 || d4 == d8 || d4 == d9 || d4 == d10 ||
                  d5 == d6 || d5 == d7 || d5 == d8 || d5 == d9 || d5 == d10 ||
                  d6 == d7 || d6 == d8 || d6 == d9 || d6 == d10 ||
                  d7 == d8 || d7 == d9 || d7 == d10 ||
                  d8 == d9 || d8 == d10 ||
                  d9 == d10)) {
                StringBuilder num = new StringBuilder();
                num.append(d1);
                num.append(d2);
                num.append(d3);
                num.append(d4);
                num.append(d5);
                num.append(d6);
                num.append(d7);
                num.append(d8);
                num.append(d9);
                num.append(d10);
                if (hasSubstringDivisibility(num.toString())) {
                    sum += Long.parseLong(num.toString());
                }
            }
        }}}}}}}}}

        return sum;
    }

    private static boolean hasSubstringDivisibility(String n) {
        for (int i = 2; i <= 8; i++) {
            int section = Integer.parseInt(n.substring(i-1, i+2));
            if (section % divisors[i] != 0) {
                return false;
            }
        }

        return true;
    }
}
