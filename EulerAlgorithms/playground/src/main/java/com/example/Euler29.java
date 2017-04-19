package com.example;

import java.math.BigInteger;
import java.util.LinkedHashSet;
import java.util.Set;

public class Euler29 {
    public static void main(String[] args) {
        long startMillis = System.currentTimeMillis();
        System.out.println(numberOfDistinctTermsInExponentialSequence(100));
        long endMillis = System.currentTimeMillis();
        System.out.println("Solved in " + (endMillis - startMillis) + " ms");
    }

    private static int numberOfDistinctTermsInExponentialSequence(int limit) {
        Set<BigInteger> sequence = new LinkedHashSet<>();
        for (int a = 2; a <= limit; a++) {
            for (int b = 2; b <= limit; b++) {
                BigInteger term = BigInteger.valueOf(a).pow(b);
                sequence.add(term);
            }
        }

        return sequence.size();
    }
}