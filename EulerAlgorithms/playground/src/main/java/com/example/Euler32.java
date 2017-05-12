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
        for (int l1 = 1; l1 <= 9; l1++) {
            for (int l2 = 1; l2 <= 9; l2++) {
                for (int r1 = 1; r1 <= 9; r1++) {
                    for (int r2 = 1; r2 <= 9; r2++) {
                        for (int r3 = 1; r3 <= 9; r3++) {
                            if (!(l1 == l2 || l1 == r1 || l1 == r2 || l1 == r3 ||
                                  l2 == r1 || l2 == r2 || l2 == r3 ||
                                  r1 == r2 || r1 == r3 ||
                                  r2 == r3)) {

                                List<Integer> digits = new ArrayList<>();
                                digits.add(l1);
                                digits.add(l2);
                                digits.add(r1);
                                digits.add(r2);
                                digits.add(r3);

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
            System.out.println(leftNum + " x " + rightNum + " = " + product);
            return product;
        }

        return 0;
    }
}