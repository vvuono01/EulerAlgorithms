package com.example;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class Euler29 {
    public static void main(String[] args) {
        long startMillis = System.currentTimeMillis();
        System.out.println(numberOfDistinctTermsInExponentialSequence(100));
        long endMillis = System.currentTimeMillis();
        System.out.println("Solved in " + (endMillis - startMillis) + " ms");
    }

    private static int numberOfDistinctTermsInExponentialSequence(int limit) {
        List<BigInteger> sequence = new ArrayList<>();
        for (int a = 2; a <= limit; a++) {
            for (int b = 2; b <= limit; b++) {
                BigInteger term = BigInteger.valueOf(a).pow(b);
                if (!sequence.contains(term)) {
                    sequence.add(term);
                }
            }
        }

        return sequence.size();
    }
}