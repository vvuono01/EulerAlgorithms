package com.example;

import java.util.ArrayList;
import java.util.List;

public class Euler26 {
    private static final int MAX_VALUE = 1000;

    public static void main(String[] args) {
        long startMillis = System.currentTimeMillis();
        System.out.println(unitFractionWithLongestRecurringCycle(MAX_VALUE));
        long endMillis = System.currentTimeMillis();
        System.out.println("Solved in " + (endMillis - startMillis) + " ms");
    }

    private static int unitFractionWithLongestRecurringCycle(int maxFraction) {
        int[] unitFractionLengths = new int[maxFraction];
        int maxIndex = maxFraction;
        int i = maxFraction + 1;
        do {
            i--;
            List<Integer> recurringCycle = new ArrayList<>();
            int index = 0;
            int digit = 1 % i;
            do {
                recurringCycle.add(digit);
                digit = (10 * recurringCycle.get(index)) % i;
                index++;
            } while (!recurringCycle.contains(digit));

            unitFractionLengths[i-1] = recurringCycle.size();
            if (unitFractionLengths[i-1] > unitFractionLengths[maxIndex-1]) {
                maxIndex = i;
            }
        }
        while (i >= unitFractionLengths[maxIndex-1]);

        return maxIndex;
    }
}