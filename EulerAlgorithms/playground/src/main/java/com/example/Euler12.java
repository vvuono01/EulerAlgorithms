package com.example;

public class Euler12 {
    public static void main(String[] args) {
        System.out.println(smallestTriangleNumberWithOverNFactors(500));
    }

    private static int smallestTriangleNumberWithOverNFactors(int n) {
        int i = n; // We know the nth triangle number will necessarily have fewer factors than n; start here to save work
        int triangleNumber, numFactors;

        do {
            i++;
            triangleNumber = nthTriangleNumber(i);
            numFactors = numberOfFactors(triangleNumber);
        } while (numFactors <= n);

        return triangleNumber;
    }

    private static int nthTriangleNumber(int n) {
        return (n * (n+1)) / 2;
    }

    private static int numberOfFactors(int n) {
        int numFactors = 0;
        for (int i = 1; i * i <= n; i++) {
            if (n % i == 0) {
                numFactors++;
            }
        }

        return numFactors * 2;
    }
}
