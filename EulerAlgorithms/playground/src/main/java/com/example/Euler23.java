package com.example;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class Euler23 {
    private static final int DEFICIENT = -1;
    private static final int PERFECT = 0;
    private static final int ABUNDANT = 1;

    private static final int SMALLEST_ABUNDANT_NUMBER = 12;
    private static final int SUM_LOWER_BOUND = SMALLEST_ABUNDANT_NUMBER + SMALLEST_ABUNDANT_NUMBER;
    private static final int SUM_UPPER_BOUND = 28123;

    public static void main(String[] args) {
        System.out.println("Starting...");
        System.out.println(sumOfAllIntegersThatCannotBeWrittenAsSumOfTwoAbundantNumbers());
    }

    private static BigInteger sumOfAllIntegersThatCannotBeWrittenAsSumOfTwoAbundantNumbers() {
        List<Integer> abundantNumbers = new ArrayList<>();
        abundantNumbers.add(SMALLEST_ABUNDANT_NUMBER);
        for (int i = SMALLEST_ABUNDANT_NUMBER + 1; i <= SUM_UPPER_BOUND; i++) {
            if (numberTypeFor(i) == ABUNDANT) {
                abundantNumbers.add(i);
            }
        }

        System.out.println("Got abundant numbers");

        List<Integer> unsummableNumbers = new ArrayList<>();
        for (int i = SUM_LOWER_BOUND; i <= SUM_UPPER_BOUND; i++) {
            unsummableNumbers.add(i);
        }

        System.out.println("Created unsummable list");

        for (int i = 0; i < abundantNumbers.size(); i++) {
            for (int j = 0; j < abundantNumbers.size(); j++) {
                Integer sum = abundantNumbers.get(i) + abundantNumbers.get(j);
                if (unsummableNumbers.contains(sum)) {
                    unsummableNumbers.remove(sum);
                }
            }
            System.out.println("Through iteration " + (i+1) + "; " + (abundantNumbers.size() - (i+1)) + " iterations to go");
        }

        return sum(unsummableNumbers);
    }

    private static int numberTypeFor(int n) {
        BigInteger divisorSum = sum(properDivisors(n));
        return divisorSum.compareTo(BigInteger.valueOf(n));
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

    private static BigInteger sum(List<Integer> list) {
        BigInteger sum = BigInteger.ZERO;
        for (Integer num : list) {
            sum = sum.add(BigInteger.valueOf(num));
        }

        return sum;
    }
}
