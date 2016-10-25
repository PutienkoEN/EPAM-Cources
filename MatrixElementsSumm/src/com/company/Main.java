package com.company;

import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) {

        MyMatrix matrix = new MyMatrix();
        matrix.getMatrixFromInput(System.in);
        int result = matrix.calculateSumm();
        matrix.printResult(result);
    }

    private static int getIntFromInput(InputStream stream) {
        int matrixSize = 0;
        Scanner input = new Scanner(stream);
        if (input.hasNextInt()) {
            matrixSize = input.nextInt();
        }

        return matrixSize;
    }

    static class MyMatrix {
        private int matrixSize;
        private int[][] matrix;

        public void getMatrixFromInput(InputStream stream) {
            Scanner scanner = new Scanner(stream);

            matrixSize = scanner.nextInt();

            matrix = new int[matrixSize][matrixSize];
            for (int row = 0; row < matrixSize; ++row) {
                for (int col = 0; col < matrixSize; ++col) {
                    matrix[row][col] = scanner.nextInt();
                }
            }
        }

        public void printResult(int result) {
            System.out.print(result);
        }

        public int calculateSumm() {
            int sumOfElements = 0;

            for (int row = 0; row < matrixSize; row++) {
                int startElement = 0;
                boolean startElementSet = false;
                int endElement = 0;
                boolean endElementSet = false;

                for (int col = 0; col < matrixSize; col++) {
                    if (matrix[row][col] > 0) {
                        if (!startElementSet) {
                            startElement = col;
                            startElementSet = true;
                        } else if (!endElementSet) {
                            endElement = col;
                            endElementSet = true;
                        }
                    }
                }

                if (startElementSet && endElementSet && (startElement != endElement) && (endElement - startElement > 1)) {
                    for (int colForSum = startElement + 1; colForSum < endElement; colForSum++) {
                        sumOfElements += matrix[row][colForSum];
                    }
                }

            }

            return sumOfElements;
        }
    }
}

