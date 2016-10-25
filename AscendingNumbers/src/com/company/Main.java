package com.company;

import java.io.InputStream;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int array[] = getInput(System.in);
        int maxCount = countAscendingNumbers(array);
        printResult(maxCount);
    }

    public static int[] getInput(InputStream stream) {
        Scanner input = new Scanner(stream);

        int count = 0;
        if (input.hasNextInt()) {
            count = input.nextInt();
        }

        int[] array = new int[count];
        for (int i = 0; i < count; i++) {
            if (input.hasNextInt()) {
                array[i] = input.nextInt();
            }
        }

        return array;
    }

    public static int countAscendingNumbers(int[] array) {
        int maxCount = 1;
        int counter = 1;

        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] < array[i + 1]) {
                counter++;
            } else {
                if (maxCount < counter) {
                    maxCount = counter;
                }
                counter = 1;
            }
        }

        if (maxCount < counter) {
            maxCount = counter;
        }

        return maxCount;
    }

    public static void printResult(int result) {
        System.out.print(result);
    }
}
