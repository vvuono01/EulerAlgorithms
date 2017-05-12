package com.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Euler35 {

    public static void main(String[] args) {
        long startMillis = System.currentTimeMillis();
        System.out.println(numberOfCircularPrimesBelow(1000000));
        long endMillis = System.currentTimeMillis();
        System.out.println("Solved in " + (endMillis - startMillis) + " ms");
    }

    private static long numberOfCircularPrimesBelow(int n) {
        Set<Integer> circularPrimes = new HashSet<>();
        circularPrimes.add(2);
        circularPrimes.add(3);
        circularPrimes.add(5);
        circularPrimes.add(7);
        for (int i = 11; i < n; i += 6) {
            if (isPrime(i)) {
                addCircularValuesToList(circularPrimes, i);
            }

            if (isPrime(i + 2)) {
                addCircularValuesToList(circularPrimes, i + 2);
            }
        }
        return circularPrimes.size();
    }

    private static void addCircularValuesToList(Set<Integer> circularPrimes, int prime) {
        if (!circularPrimes.contains(prime)) {
            String primeString = String.valueOf(prime);
            if (!primeString.contains("0") &&
                !primeString.contains("2") &&
                !primeString.contains("5")) {
                Set<Integer> currentNumbers = new HashSet<>();
                currentNumbers.add(prime);
                int currentRotation = getNextRotation(prime);
                if (currentRotation != prime) {
                    boolean isCircular;
                    do {
                        isCircular = isPrime(currentRotation);
                        if (isCircular) {
                            currentNumbers.add(currentRotation);
                        }
                        currentRotation = getNextRotation(currentRotation);
                    } while (isCircular && !currentNumbers.contains(currentRotation));

                    if (currentNumbers.size() == String.valueOf(prime).length()) {
                        circularPrimes.addAll(currentNumbers);
                    }
                } else {
                    circularPrimes.add(prime);
                }
            }
        }
    }

    private static boolean isPrime(int n) {
        if (n > 1 && n <= 3) {
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

    private static int getNextRotation(int n) {
        if (n < 10) {
            return n;
        }

        List<Integer> digits = new ArrayList<>();
        int tracker = n;
        while (tracker > 0) {
            digits.add(tracker % 10);
            tracker = tracker / 10;
        }
        Collections.reverse(digits);

        String newNum = "";
        for (int i = 1; i < digits.size(); i++) {
            newNum += digits.get(i).toString();
        }

        newNum += digits.get(0).toString();
        return Integer.parseInt(newNum);
    }
}
