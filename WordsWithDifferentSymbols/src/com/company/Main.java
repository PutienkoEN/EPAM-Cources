package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String[] text = readText();
        /*String[] text = new String[] {"The", "Java", "programming", "language", "is", "a",
                "general-purpose", "concurrent", "class-based", "object-oriented", "language"};
                */
        //String[] text = new String[] {"abcd"," ", "abcd", " ", "asdf"};
        String[] result = findWords(text);
        printText(result);
    }

    private static String[] readText() {
        Scanner input = new Scanner(System.in);

        int count = input.nextInt();

        ArrayList<String> text = new ArrayList<>();

        for (int i = 0; i <count ; i++) {
            if (input.hasNext()) {
                text.add(input.next());
            }
        }

        input.close();

        return text.toArray(new String[text.size()]);
    }

    private static String[] findWords(String[] text) {
        ArrayList<String> words = new ArrayList<String>();

        boolean firstAdd = true;
        for(String str : text){
            if (!haveRepeatedChars(str) && !words.contains(str)){
                words.add(str);
            }
        }
        return words.toArray(new String[words.size()]);
    }

    private static boolean haveRepeatedChars(String str) {
        if (str.length() == 1) {
            return false;
        }

        boolean haveRepeatedChars = false;
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length - 1; i++) {
            for (int j = i + 1; j < chars.length; j++) {
                if (chars[i] == chars[j]) {
                    haveRepeatedChars = true;
                }
            }
        }

        return haveRepeatedChars;
    }
    private static String buildStringResult(String[] text){
        StringBuilder sb = new StringBuilder();
        if (text.length == 0){
            sb.append("NOT FOUND");
        } else{
            for (int i = 0; i < text.length ; i++) {
                if (i != 0){
                    sb.append(" ");
                }
                sb.append(text[i]);
            }
        }
        return  sb.toString();
    }
    private static void printText(String[] text) {
        String result = buildStringResult(text);
        System.out.print(result);

    }
}
