package com.example;

import java.util.ArrayList;
import java.util.List;

public class Euler32 {
    private static List<Integer> products = new ArrayList<>();

    public static void main(String[] args) {
        long startMillis = System.currentTimeMillis();
        System.out.println(sumOfPandigitalIdentities());
        long endMillis = System.currentTimeMillis();
        System.out.println("Solved in " + (endMillis - startMillis) + " ms");
    }

    private static long sumOfPandigitalIdentities() {
        long sum = 0;
        for (int d1 = 1; d1 <= 9; d1++) {
            for (int d2 = 1; d2 <= 9; d2++) {
                for (int d3 = 1; d3 <= 9; d3++) {
                    for (int d4 = 1; d4 <= 9; d4++) {
                        for (int d5 = 1; d5 <= 9; d5++) {
                            if (!(d1 == d2 || d1 == d3 || d1 == d4 || d1 == d5 ||
                                  d2 == d3 || d2 == d4 || d2 == d5 ||
                                  d3 == d4 || d3 == d5 ||
                                  d4 == d5)) {

                                List<Integer> digits = new ArrayList<>();
                                digits.add(d1);
                                digits.add(d2);
                                digits.add(d3);
                                digits.add(d4);
                                digits.add(d5);

                                int product = pandigitalValue(digits, true);
                                if (product != 0 && !products.contains(product)) {
                                    sum += product;
                                    products.add(product);
                                }

                                product = pandigitalValue(digits, false);
                                if (product != 0 && !products.contains(product)) {
                                    sum += product;
                                    products.add(product);
                                }
                            }
                        }
                    }
                }
            }
        }

        return sum;
    }

    // Return the product if it is pandigital; return 0 if not
    private static int pandigitalValue(List<Integer> digits, boolean twoByThree) {
        int leftNum = (twoByThree ? ((digits.get(0) * 10) + digits.get(1)) : digits.get(0));
        int rightNum = (twoByThree ? 0 : (digits.get(1) * 1000)) + (digits.get(2) * 100) + (digits.get(3) * 10) + digits.get(4);
        int product = leftNum * rightNum;

        if (product < 1000 || product >= 10000) {
            return 0;
        }

        int productTracker = product;
        while (productTracker > 0) {
            int digit = productTracker % 10;

            if (digit == 0 || digits.contains(digit)) {
                return 0;
            }

            digits.add(digit);
            productTracker = productTracker / 10;
        }

        if (digits.size() == 9) {
            return product;
        }

        return 0;
    }
}