package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        String[] text = readText();
        int avg = findAvg(text);
        ArrayList<String> lessThanAvg = findStringsLessThanAvg(text, avg);
        printText(lessThanAvg, avg);
    }

    private static String[] readText() {
        Scanner input = new Scanner(System.in);

        int count = input.nextInt();
        input.nextLine();

        String[] text = new String[count];
        for (int i = 0; i < count; i++) {
            text[i] = input.nextLine();
        }
        input.close();

        return text;
    }

    private static int findAvg(String[] text) {
        int avg = 0;
        for (String str : text) {
            avg += str.length();
        }
        avg = avg / text.length;
        return avg;
    }

    private static ArrayList<String> findStringsLessThanAvg(String[] text, int avg) {
        ArrayList<String> lessThanAvg;
        lessThanAvg = new ArrayList<String>();
        for (String str : text) {
            if (str.length() < avg) {
                lessThanAvg.add(str);
            }
        }
        return lessThanAvg;
    }

    private static void printText(ArrayList<String> text, int avgLength) {
        System.out.printf("AVERAGE (%d)%n", avgLength);
        for(String str : text){
            System.out.printf("(%d): \"%s\"%n", str.length(), str);
        }

    }
}
