package com.example;

import java.util.ArrayList;
import java.util.List;

public class Euler50 {
    public static void main(String[] args) {
        long startMillis = System.currentTimeMillis();
        System.out.println(primeThatCanBeWrittenAsTheSumOfTheMostConsecutivePrimes(1000000));
        long endMillis = System.currentTimeMillis();
        System.out.println("Solved in " + (endMillis - startMillis) + " ms");
    }

    private static long primeThatCanBeWrittenAsTheSumOfTheMostConsecutivePrimes(int limit) {
        List<Integer> primes = new ArrayList<>();
        primes.add(2);
        primes.add(3);
        for (int i = 5; i <= 10000; i += 6) {
            if (isPrime(i)) {
                primes.add(i);
            }

            if (isPrime(i+2)) {
                primes.add(i+2);
            }
        }

        int largestPrime = 593;
        int sum = 0;
        for (int i = 0; i < primes.size(); i++) {
            sum += primes.get(i);

            if (sum > largestPrime) {
                if (isPrime(sum)) {
                    largestPrime = sum;
                    if (largestPrime > limit) {
                        break;
                    }
                }
            }
        }

        for (int i = 0; i < primes.size(); i++) {
            largestPrime -= primes.get(i);
            if (isPrime(largestPrime)) {
                if (largestPrime < limit) {
                    break;
                }
            }
        }

        return largestPrime;
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
}
