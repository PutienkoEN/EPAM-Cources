package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int monthNum = getMonthNumber();
        printMonth(monthNum);
    }

    private static int getMonthNumber() {
        int matrixSize = 0;
        try (Scanner input = new Scanner(System.in)) {
            if (input.hasNextInt()) {
                matrixSize = input.nextInt();
            }
        }
        return matrixSize;
    }

    private static void printMonth(int monthNumber) {
        String monthName;

        switch (monthNumber) {
            case 1:
                monthName = "JANUARY";
                break;
            case 2:
                monthName = "FEBRUARY";
                break;
            case 3:
                monthName = "MARCH";
                break;
            case 4:
                monthName = "APRIL";
                break;
            case 5:
                monthName = "MAY";
                break;
            case 6:
                monthName = "JUNE";
                break;
            case 7:
                monthName = "JULY";
                break;
            case 8:
                monthName = "AUGUST";
                break;
            case 9:
                monthName = "SEPTEMBER";
                break;
            case 10:
                monthName = "OCTOBER";
                break;
            case 11:
                monthName = "NOVEMBER";
                break;
            case 12:
                monthName = "DECEMBER";
                break;
            default:
                monthName = "INCORRECT INPUT DATA";
        }

        System.out.print(monthName);
    }
}
