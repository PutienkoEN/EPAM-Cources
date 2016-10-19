package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String[] text = readText();
        String minWord = findWordWithMininumDifferentSymbols(text);
        printText(minWord);
    }

    private static String[] readText() {
        Scanner input = new Scanner(System.in);

        int count = input.nextInt();

        String[] text = new String[count];
        for (int i = 0; i < count; i++) {
            text[i] = input.next();
        }
        input.close();

        return text;
    }
    private static String findWordWithMininumDifferentSymbols(String[] text){
        String minStr = text[0];
        int minUniqueChars = 255;

        for (String str : text){
            int uniqueChars;
            uniqueChars = countUniqueChars(str);
            if (minUniqueChars > uniqueChars){
                minUniqueChars = uniqueChars;
                minStr = str;
            }
        }

        return minStr;
    }

    private static int countUniqueChars(String str){
        char[] charArray = str.toCharArray();
        ArrayList<Character> differentChars = new ArrayList<>();

        for(int i = 0; i < charArray.length; i++){
            boolean isUnique = false;

            for (int j = i; j < charArray.length; j++) {
                if (charArray[i] == charArray[j] && !differentChars.contains(charArray[j])){
                    isUnique = true;
                }
            }

            if (isUnique) {
                differentChars.add(charArray[i]);
            }
        }

        return differentChars.size();
    }
    private static boolean compareStrings(String a, String b) {
        int lengthDifference = a.length() - b.length();
        return lengthDifference < 0;
    }

    private static void printText(String str) {
            System.out.println(str);
    }
}
