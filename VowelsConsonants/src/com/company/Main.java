package com.company;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        String[] text = readText();
        String[] onlyLat = findLatin(text);
        int count = findWords(onlyLat);
        printText(count);
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

    private  static String[] findLatin(String[] text){
        ArrayList<String> onlyLat = new ArrayList<String>();

        for(String str : text){
            if (str.matches("[a-zA-Z]+")){
                onlyLat.add(str);
            }
        }
        return onlyLat.toArray(new String[onlyLat.size()]);
    }

    private  static  int findWords(String[] text){
        int countOfMatches = 0;
        for(String str : text){
            if (checkVowConsEquals(str))
                countOfMatches++;
        }

        return countOfMatches;
    }

    private  static boolean checkVowConsEquals(String str){
        int vowelCount = 0;
        Pattern p = Pattern.compile("[aeiouAEIOU]");
        Matcher m = p.matcher(str);
        while (m.find()){
            vowelCount++;
        }

        int consonantsCount;
        consonantsCount =  str.length() - vowelCount;

        boolean vowEqualsCon = false;
        if (consonantsCount == vowelCount){
            vowEqualsCon = true;
        }
        return  vowEqualsCon;
    }
    private static boolean compareStrings(String a, String b) {
        int lengthDifference = a.length() - b.length();
        return lengthDifference < 0;
    }

    private static void printText(int count) {
        System.out.printf("%d%n", count);
    }
}
