package com.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Euler50 {
    public static void main(String[] args) {
        long startMillis = System.currentTimeMillis();
        System.out.println(primeThatCanBeWrittenAsTheSumOfTheMostConsecutivePrimes(1000000));
        long endMillis = System.currentTimeMillis();
        System.out.println("Solved in " + (endMillis - startMillis) + " ms");
    }

    private static long primeThatCanBeWrittenAsTheSumOfTheMostConsecutivePrimes(int limit) {
        List<Long> primeList = new ArrayList<>();
        primeList.add(2l);
        primeList.add(3l);
        for (long i = 5; i <= 1000000; i += 6) {
            if (isPrime(i)) {
                primeList.add(i);
            }

            if (isPrime(i+2)) {
                primeList.add(i+2);
            }
        }

        Long[] primes = primeList.toArray(new Long[primeList.size()]);

        int numberOfPrimes = 0;
        long result = 0;
        long[] primeSum = new long[primes.length+1];
        primeSum[0] = 0;
        for (int i = 0; i < primes.length; i++) {
            primeSum[i+1] = primeSum[i] + primes[i];
        }

        for (int i = numberOfPrimes; i < primeSum.length; i++) {
            for (int j = i-(numberOfPrimes+1); j >= 0; j--) {
                if (primeSum[i] - primeSum[j] > limit) break;

                if (Arrays.binarySearch(primes, primeSum[i] - primeSum[j]) >= 0) {
                    numberOfPrimes = i - j;
                    result = primeSum[i] - primeSum[j];
                }
            }
        }

        return result;
    }

    private static boolean isPrime(long n) {
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
}
