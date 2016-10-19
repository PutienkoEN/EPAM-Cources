package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String[] text = readText();
        String[] onlyInt = getIntNumbersAsString(text);
        String result = getPalindromeNumber(onlyInt);
        printText(result);
    }

    private static String[] readText() {
        Scanner input = new Scanner(System.in);

        int count = input.nextInt();

        ArrayList<String> text = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            if (input.hasNext()) {
                text.add(input.next());
            }
        }

        input.close();

        return text.toArray(new String[text.size()]);
    }

    private static String[] getIntNumbersAsString(String[] text) {
        ArrayList<String> onlyInt = new ArrayList<>();
        for (String str : text) {
            if (str.matches("[0-9]+")) {
                onlyInt.add(str);
            }
        }
        return onlyInt.toArray(new String[onlyInt.size()]);
    }

    private static String getPalindromeNumber(String[] numbers) {
        String ourNumber = "NOT FOUND";
        int alreadyFoundedPalindromesCount = 0;

        for (String num : numbers) {
            if (checkNumber(num) && alreadyFoundedPalindromesCount < 2) {
                ourNumber = num;
                alreadyFoundedPalindromesCount++;
            }
        }

        return ourNumber;
    }

    private static boolean checkNumber(String str) {
        if (str.length() == 1) {
            return false;
        }

        char[] number = str.toCharArray();
        int numOfPairs = number.length / 2;
        boolean palindrome = true;

        for (int i = 0; i < numOfPairs; i++) {
            if (number[i] != number[number.length - 1 - i]) {
                palindrome = false;
            }
        }
        return palindrome;
    }

    private static void printText(String text) {
        System.out.print(text);

    }
}
