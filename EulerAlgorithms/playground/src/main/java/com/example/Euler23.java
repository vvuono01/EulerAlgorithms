package com.example;

import java.util.ArrayList;
import java.util.List;

public class Euler23 {
    private static final int ABUNDANT = 1;

    private static final int SMALLEST_ABUNDANT_NUMBER = 12;
    private static final int SUM_UPPER_BOUND = 28123;

    public static void main(String[] args) {
        System.out.println(sumOfAllIntegersThatCannotBeWrittenAsSumOfTwoAbundantNumbers());
    }

    private static long sumOfAllIntegersThatCannotBeWrittenAsSumOfTwoAbundantNumbers() {
        List<Integer> abundantNumbers = new ArrayList<>();
        for (int i = SMALLEST_ABUNDANT_NUMBER; i <= SUM_UPPER_BOUND; i++) {
            if (numberTypeFor(i) == ABUNDANT) {
                abundantNumbers.add(i);
            }
        }

        boolean[] unsummableNumbers = new boolean[SUM_UPPER_BOUND];

        for (int i = 0; i < abundantNumbers.size(); i++) {
            for (int j = i; j < abundantNumbers.size(); j++) {
                int abundantNumberSum = abundantNumbers.get(i) + abundantNumbers.get(j);
                if (abundantNumberSum < SUM_UPPER_BOUND) {
                    unsummableNumbers[abundantNumberSum] = true;
                }
            }
        }

        int sum = 0;
        for (int i = 0; i < unsummableNumbers.length; i++) {
            if (!unsummableNumbers[i]) {
                sum += i;
            }
        }

        return sum;
    }

    private static int numberTypeFor(long n) {
        Long divisorSum = sum(properDivisors(n));
        return divisorSum.compareTo(n);
    }

    private static List<Integer> properDivisors(long n) {
        List<Integer> divisors = new ArrayList<>();
        divisors.add(1);
        for (int i = 2; i <= (n / 2); i++) {
            if (n % i == 0) {
                divisors.add(i);
            }
        }

        return divisors;
    }

    private static long sum(List<Integer> list) {
        long sum = 0;
        for (Integer num : list) {
            sum += num;
        }

        return sum;
    }
}
