package com.example;

import java.util.ArrayList;
import java.util.List;

public class Euler46 {
    public static void main(String[] args) {
        long startMillis = System.currentTimeMillis();
        System.out.println(smallestCompositeNumberThatCannotBeWrittenAsTheSumOfAPrimeAndTwiceASquare());
        long endMillis = System.currentTimeMillis();
        System.out.println("Solved in " + (endMillis - startMillis) + " ms");
    }

    private static long smallestCompositeNumberThatCannotBeWrittenAsTheSumOfAPrimeAndTwiceASquare() {
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

        int result = 1;
        boolean notFound = true;

        while (notFound) {
            result += 2;

            int j = 0;
            notFound = false;
            while (result >= primes.get(j)) {
                if(isTwiceASquare(result - primes.get(j))){
                    notFound = true;
                    break;
                }
                j++;
            }
        }

        return result;
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

    private static boolean isTwiceASquare(int n) {
        double number = Math.sqrt(n / 2);
        return number == ((int) number);
    }
}
