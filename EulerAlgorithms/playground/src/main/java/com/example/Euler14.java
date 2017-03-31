package com.example;

import java.util.HashMap;
import java.util.Map;

public class Euler14 {

    private static Map<Long, Long> lengths;

    public static void main(String[] args) {
        long startMillis = System.currentTimeMillis();
        System.out.println(longestCollatzChainUnder(1000000));
        long endMillis = System.currentTimeMillis();
        System.out.println("Solved in " + (endMillis - startMillis) + " ms");
    }

    private static int longestCollatzChainUnder(int limit) {
        lengths = new HashMap<>();
        lengths.put(1L, 1L);
        lengths.put(2L, 2L);
        int largestIndex = 2;
        long largestLength = 2L;
        for (int i = 3; i < limit; i += 2) {
            if (!lengths.containsKey(i)) {
                long length = collatzLength(i);
                if (length > largestLength) {
                    largestIndex = i;
                    largestLength = length;
                }
            }
        }
        return largestIndex;
    }
    private static long collatzLength(long n) {
        long length = 1;

        while (n > 1) {
            if (lengths.containsKey(n)) {
                length += lengths.get(n);
                break;
            } else {
                n = (n % 2 == 0) ? (n / 2) : ((3 * n) + 1);
                length++;
            }
        }
        return length;
    }
}
