package com.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Euler35 {

    public static void main(String[] args) {
        long startMillis = System.currentTimeMillis();
        System.out.println(numberOfCircularPrimesBelow(1000000));
        long endMillis = System.currentTimeMillis();
        System.out.println("Solved in " + (endMillis - startMillis) + " ms");
    }

    private static long numberOfCircularPrimesBelow(int n) {
        List<Integer> circularPrimes = new ArrayList<>();
        circularPrimes.add(2);
        circularPrimes.add(3);
        for (int i = 5; i < n; i += 6) {
            if (isPrime(i)) {
                addCircularValuesToList(circularPrimes, i);
            }

            if (isPrime(i + 2)) {
                addCircularValuesToList(circularPrimes, i + 2);
            }
        }
        return circularPrimes.size();
    }
    
    private static void addCircularValuesToList(List<Integer> circularPrimes, int prime) {
        if (!circularPrimes.contains(prime) && !String.valueOf(prime).contains("0")) {
            List<Integer> currentNumbers = new ArrayList<>();
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
