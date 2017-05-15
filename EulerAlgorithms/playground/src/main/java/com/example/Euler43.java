package com.example;

public class Euler43 {
    private static int[] primes = {0, 1, 2, 3, 5, 7, 11, 13, 17};

    public static void main(String[] args) {
        long startMillis = System.currentTimeMillis();
        System.out.println(sumOfSubstringDivisibilityPandigitalNumbers());
        long endMillis = System.currentTimeMillis();
        System.out.println("Solved in " + (endMillis - startMillis) + " ms");
    }

    private static long sumOfSubstringDivisibilityPandigitalNumbers() {
        long sum = 0;
        for (int a = 1; a <= 9; a++) {
        for (int b = 0; b <= 9; b++) {
        for (int c = 0; c <= 9; c++) {
        for (int d = 0; d <= 9; d++) {
        for (int e = 0; e <= 9; e++) {
        for (int f = 0; f <= 9; f++) {
        for (int g = 0; g <= 9; g++) {
        for (int h = 0; h <= 9; h++) {
        for (int i = 0; i <= 9; i++) {
        for (int j = 0; j <= 9; j++) {
            if (!(a == b || a == c || a == d || a == e || a == f || a == g || a == h || a == i || a == j ||
                  b == c || b == d || b == e || b == f || b == g || b == h || b == i || b == j ||
                  c == d || c == e || c == f || c == g || c == h || c == i || c == j ||
                  d == e || d == f || d == g || d == h || d == i || d == j ||
                  e == f || e == g || e == h || e == i || e == j ||
                  f == g || f == h || f == i || f == j ||
                  g == h || g == i || g == j ||
                  h == i || h == j ||
                  i == j)) {
                StringBuilder num = new StringBuilder();
                num.append(a);
                num.append(b);
                num.append(c);
                num.append(d);
                num.append(e);
                num.append(f);
                num.append(g);
                num.append(h);
                num.append(i);
                num.append(j);
                if (hasSubstringDivisibility(num.toString())) {
                    sum += Long.parseLong(num.toString());
                }
            }
        }}}}}}}}}}

        return sum;
    }

    private static boolean hasSubstringDivisibility(String n) {
        for (int i = 2; i <= 8; i++) {
            int section = Integer.parseInt(n.substring(i-1, i+2));
            if (section % primes[i] != 0) {
                return false;
            }
        }

        return true;
    }
}
