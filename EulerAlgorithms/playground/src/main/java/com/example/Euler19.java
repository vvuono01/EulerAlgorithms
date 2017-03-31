package com.example;

public class Euler19 {

    private final static int SUNDAY = 0;
    private final static int MONDAY = 1;

    private final static int JANUARY = 0;
    private final static int FEBRUARY = 1;
    private final static int DECEMBER = 11;

    private final static int START_YEAR = 1900;
    private final static int END_YEAR = 2000;

    private static int[] DAYS_PER_MONTH = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    public static void main(String[] args) {
        long startMillis = System.currentTimeMillis();
        System.out.println(numSundaysIn20thCentury());
        long endMillis = System.currentTimeMillis();
        System.out.println("Solved in " + (endMillis - startMillis) + " ms");
    }

    private static int numSundaysIn20thCentury() {
        int previousDayOfWeek = 0;
        int previousMonth = 0;
        int previousYear = 0;

        int sundays = 0;
        for (int year = START_YEAR; year <= END_YEAR; year++) {
            for (int month = JANUARY; month <= DECEMBER; month++) {
                if (year == START_YEAR && month == JANUARY) {
                    // 1 Jan 1900 was a Monday
                    previousDayOfWeek = MONDAY;
                } else {
                    previousDayOfWeek = dayOfWeekForFirstOfNextMonth(previousDayOfWeek, previousMonth, previousYear);
                }

                previousMonth = month;
                previousYear = year;

                // Don't count 1900 towards the Sunday count
                if (year != START_YEAR && previousDayOfWeek == SUNDAY) {
                    sundays++;
                }
            }
        }

        return sundays;
    }

    private static int dayOfWeekForFirstOfNextMonth(int previousDayOfWeek, int previousMonth, int previousYear) {
        int dayOfWeek = previousDayOfWeek + (daysInMonth(previousMonth, previousYear) % 7); // The day offset is only affected by the difference between the days in the month and 28
        return dayOfWeek % 7; // Account for it overflowing past 6 (Saturday)
    }

    private static int daysInMonth(int month, int year) {
        int days = DAYS_PER_MONTH[month];
        if (month == FEBRUARY && isLeapYear(year)) {
            days++;
        }

        return days;
    }

    private static boolean isLeapYear(int year) {
        return year % 400 == 0 || (year % 100 != 0 && year % 4 == 0);
    }
}