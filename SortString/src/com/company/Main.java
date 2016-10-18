package com.company;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String[] text = readText();
        text = sortText(text);
        printText(text);

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

    private static String[] sortText(String[] text) {
        for (int i = 0; i < text.length - 1; i++) {
            for (int j = 0; j < text.length - 1 - i; j++) {
                boolean nextItemGreater = compareStrings(text[j], text[j + 1]);

                if (!nextItemGreater) {
                    String tempText = text[j];
                    text[j] = text[j + 1];
                    text[j + 1] = tempText;
                }

            }
        }
        return text;
    }

    private static boolean compareStrings(String a, String b) {
        int lengthDifference = a.length() - b.length();
        boolean x = (lengthDifference < 0) || (lengthDifference == 0 && a.compareTo(b) < 0);
        return x;

    }

    private static void printText(String[] text) {

        for (int i = 0; i < text.length; i++) {
            System.out.printf("(%s): \"%s\"\n", text[i].length(), text[i]);
        }

    }
}

