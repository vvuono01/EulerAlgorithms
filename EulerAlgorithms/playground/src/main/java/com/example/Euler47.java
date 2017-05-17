package com.example;

import java.util.ArrayList;
import java.util.List;

public class Euler47 {
    private static final int LOWER_BOUND = 2 * 3 * 5 * 7;

    public static void main(String[] args) {
        long startMillis = System.currentTimeMillis();
        System.out.println(firstOfFourConsecutiveIntegersWithFourDistinctPrimeFactors());
        long endMillis = System.currentTimeMillis();
        System.out.println("Solved in " + (endMillis - startMillis) + " ms");
    }

    private static long firstOfFourConsecutiveIntegersWithFourDistinctPrimeFactors() {
        List<Integer> primes = new ArrayList<>();
        primes.add(2);
        primes.add(3);
        for (int i = 5; i <= 1000; i += 6) {
            if (isPrime(i)) {
                primes.add(i);
            }

            if (isPrime(i+2)) {
                primes.add(i+2);
            }
        }

        int i = LOWER_BOUND;
        int numConsecutive = 1;
        int result = LOWER_BOUND;
        while (true) {
            i++;

            if (numberOfPrimeFactors(i, primes) == 4) {
                if (numConsecutive == 0) {
                    result = i;
                }

                numConsecutive++;

                if (numConsecutive == 4) {
                    return result;
                }
            } else {
                numConsecutive = 0;
                result = 0;
            }
        }
    }

    private static boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        } else if (n > 1 && n <= 3) {
            return true;
        } else if (n % 2 == 0 || n % 3 == 0) {
            return false;
        }

        for (int i = 5; (i * i) <= n; i += 6) {
            if (n % i == 0 || n % (i + 2) == 0) {
                return false;
            }
        }
        return true;
    }

    private static int numberOfPrimeFactors(int n, List<Integer> primes) {
        int numPrimeFactors = 0;
        for (int i = 0; i < primes.size(); i++) {
            int prime = primes.get(i);

            if (prime > n) {
                break;
            }

            if (n % primes.get(i) == 0) {
                numPrimeFactors++;
            }
        }

        return numPrimeFactors;
    }
}
