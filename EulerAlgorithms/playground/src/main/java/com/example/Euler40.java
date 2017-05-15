package com.example;

public class Euler40 {
    private static StringBuilder champernownesConstant;

    public static void main(String[] args) {
        long startMillis = System.currentTimeMillis();
        System.out.println(champernownesConstantExpressionValue());
        long endMillis = System.currentTimeMillis();
        System.out.println("Solved in " + (endMillis - startMillis) + " ms");
    }

    private static int champernownesConstantExpressionValue() {
        return d(1) * d(10) * d(100) * d(1000) * d(10000) * d(100000) * d(1000000);
    }

    private static int d(int n) {
        if (champernownesConstant == null) {
            generateChampernownesConstant();
        }

        return Integer.parseInt(champernownesConstant.charAt(n) + "");
    }

    private static void generateChampernownesConstant() {
        int i = 0;
        champernownesConstant = new StringBuilder();
        do {
            champernownesConstant.append(i++);
        } while (champernownesConstant.length() <= 1000000);
    }
}
