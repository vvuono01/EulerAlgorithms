package com.example;

import java.util.ArrayList;
import java.util.List;

public class Euler21 {
    public static void main(String[] args) {
        System.out.println(sumOfAmicableNumbersUnder(10000));
    }

    private static int sumOfAmicableNumbersUnder(int n) {
        List<Integer> amicableNumbers = new ArrayList<>();
        for (int a = 1; a < n; a++) {
            if (!amicableNumbers.contains(a)) {
                int b = d(a);
                if (a != b && d(b) == a) {
                    amicableNumbers.add(a);
                    amicableNumbers.add(b);
                }
            }
        }

        return sum(amicableNumbers);
    }

    private static int d(int n) {
        return sum(properDivisors(n));
    }

    private static List<Integer> properDivisors(int n) {
        List<Integer> divisors = new ArrayList<>();
        divisors.add(1);
        for (int i = 2; i <= (n / 2); i++) {
            if (n % i == 0) {
                divisors.add(i);
            }
        }

        return divisors;
    }

    private static int sum(List<Integer> list) {
        int sum = 0;
        for (Integer num : list) {
            sum += num;
        }

        return sum;
    }
}
