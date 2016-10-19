package com.company;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //String[] text = readText();
        String[] text = new String[]{"The", "original", "and", "reference", "implementation",
                "Java", "compilers", "were", "originally", "released", "by", "Sun"};

        String result = findWord(text);
        printText(result);
    }

    private static String[] readText() {
        Scanner input = new Scanner(System.in);

        int count = input.nextInt();
        input.nextLine();

        String[] text = new String[count];
        for (int i = 0; i < count; i++) {
            text[i] = input.next();
        }
        input.close();

        return text;
    }

    private static String findWord(String[] text) {
        for (String str : text) {
            if (checkWord(str)) {
                return str;
            }
        }
        return "NOT FOUND";
    }

    private static boolean checkWord(String str) {
        if (str.length() == 1) {
            return false;
        }

        char[] chArray = str.toCharArray();
        for (int i = 0; i < chArray.length - 1; i++) {
            if (chArray[i + 1] <= chArray[i]) {
                return false;
            }
        }
        return true;
    }

    private static void printText(String word) {
        System.out.printf("%s%n", word);
    }
}
