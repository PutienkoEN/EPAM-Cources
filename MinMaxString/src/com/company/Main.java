package com.company;
import java.util.Scanner;
import java.util.StringJoiner;

public class Main {
    private static String min;
    private static String max;

    public static void main(String[] args) {
        String[] text = readText();
        findMinMax(text);
        printText();
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

    private static void findMinMax(String[] text) {
        min = text[0];
        max = text[0];

        for (int i = 0; i < text.length; i++){
            if (text[i].length() >= max.length()) {
                max = text[i];
            }
            if (text[i].length() <= min.length()){
                min = text[i];
            }
        }
    }

    private static boolean compareStrings(String a, String b) {
        int lengthDifference = a.length() - b.length();
        return lengthDifference < 0;
    }

    private static void printText() {
        System.out.printf("MIN (%d): \"%s\"%n", min.length(), min);
        System.out.printf("MAX (%d): \"%s\"%n", max.length(), max);
    }
}
