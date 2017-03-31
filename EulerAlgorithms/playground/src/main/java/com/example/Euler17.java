package com.example;

public class Euler17 {

    private static int[] onesLetters = new int[] { 0, 3, 3, 5, 4, 4, 3, 5, 5, 4 };
    private static int[] tensLetters = new int[] { 0, 0, 6, 6, 5, 5, 5, 7, 6, 6 };
    private static int[] teensLetters = new int[] { 3, 6, 6, 8, 8, 7, 7, 9, 8, 8 };

    public static void main(String[] args) {
        long startMillis = System.currentTimeMillis();
        System.out.println(numberOfLettersInWordStringUpTo(1000));
        long endMillis = System.currentTimeMillis();
        System.out.println("Solved in " + (endMillis - startMillis) + " ms");
    }

    private static int numberOfLettersInWordStringUpTo(int num) {
        int sum = 0;
        for (int i = 1; i <= num; i++) {
            sum += lettersPerNumber(i);
        }

        return sum;
    }

    private static int baseLetters(int tens, int ones) {
        if (tens == 1) {
            return teensLetters[ones];
        }

        return tensLetters[tens] + onesLetters[ones];
    }

    private static int hundredsLetters(int hundreds, boolean and) {
        return onesLetters[hundreds] + 7 + (and ? 3 : 0);
    }

    private static int thousandsLetters(int thousands) {
        return onesLetters[thousands] + 8;
    }

    private static int lettersPerNumber(int num) {
        String numString = String.format("%04d", num);
        int ones = Integer.parseInt(String.valueOf(numString.charAt(3)));
        int tens = Integer.parseInt(String.valueOf(numString.charAt(2)));
        int letters = baseLetters(tens, ones);

        if (num >= 100) {
            if (num != 1000) {
                int hundreds = Integer.parseInt(String.valueOf(numString.charAt(1)));
                letters += hundredsLetters(hundreds, num % 100 != 0);
            }

            if (num >= 1000) {
                int thousands = Integer.parseInt(String.valueOf(numString.charAt(0)));
                letters += thousandsLetters(thousands);
            }
        }

        return letters;
    }
}
