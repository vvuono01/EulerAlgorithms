package com.example;

public class Euler45 {
    public static void main(String[] args) {
        long startMillis = System.currentTimeMillis();
        System.out.println(nextTriangleNumberThatIsPentagonalAndHexagonalAfter(285));
        long endMillis = System.currentTimeMillis();
        System.out.println("Solved in " + (endMillis - startMillis) + " ms");
    }

    private static long nextTriangleNumberThatIsPentagonalAndHexagonalAfter(int previous) {
        long n = previous;
        while (true) {
            n++;
            long tn = triangleNumber(n);
            if (isPentagonal(tn) && isHexagonal(tn)) {
                return tn;
            }
        }
    }

    private static long triangleNumber(long n) {
        return (n * (n + 1)) / 2;
    }

    private static boolean isPentagonal(long n) {
        double number = (Math.sqrt((24.0 * n) + 1.0) + 1.0) / 6.0;
        return number == (int) number;
    }

    private static boolean isHexagonal(long n) {
        double number = (Math.sqrt((8.0 * n) + 1.0) + 1.0) / 4.0;
        return number == (int) number;
    }
}
