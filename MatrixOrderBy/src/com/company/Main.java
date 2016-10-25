package com.company;

import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) {

        MyMatrix matrix = new MyMatrix();
        matrix.getMatrixFromInput(System.in);
        matrix.orderMatrixByColumn();
        matrix.printMatrix();
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
        private int columnNumber;
        private int[][] matrix;

        public void getMatrixFromInput(InputStream stream){
            Scanner scanner = new Scanner(stream);

            columnNumber = scanner.nextInt();
            matrixSize = scanner.nextInt();

            matrix = new int[matrixSize][matrixSize];
            for (int row = 0; row < matrixSize; ++row) {
                for (int col = 0; col < matrixSize; ++col) {
                    matrix[row][col] = scanner.nextInt();
                }
            }
        }

        public void orderMatrixByColumn() {

            int[] columnOrder = calculateColumnOrder();
            orderMatrixColumns(columnOrder);

        }

        public void printMatrix() {
            System.out.print(matrixSize + "\n\n");

            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[i].length; j++) {
                    System.out.print(matrix[i][j]);
                    if (j != matrix[i].length - 1) {
                        System.out.print("\t");
                    } else {
                        System.out.print("\n\n");
                    }
                }
            }
        }

        private int[] calculateColumnOrder() {
            //We don't want replace all elements in our array at once
            //Probably better sort only needed column, and remember "id" of elements we replaced

            int[] colOrderedNumbers = new int[matrixSize];

            for (int i = 0; i < matrixSize; i++) {
                colOrderedNumbers[i] = i;
            }

            int[] tempColumnForOrder = new int[matrixSize];
            for (int i = 0; i < matrixSize; i++) {
                tempColumnForOrder[i] = matrix[i][columnNumber];
            }

            for (int i = 0; i < matrixSize; i++) {
                for (int j = 0; j < matrixSize - 1; j++) {
                    if (tempColumnForOrder[j] > tempColumnForOrder[j + 1]){
                        int val = tempColumnForOrder[j];
                        tempColumnForOrder[j] = tempColumnForOrder[j + 1];
                        tempColumnForOrder[j + 1]= val;

                        int temVal = colOrderedNumbers[j];
                        colOrderedNumbers[j] = colOrderedNumbers[j + 1];
                        colOrderedNumbers[j + 1] = temVal;
                    }
                }
            }

            return  colOrderedNumbers;
        }

        private void orderMatrixColumns(int[] columnOrder) {
            int[][] tempMatrix = new int[matrixSize][matrixSize];

            for (int i = 0; i < matrixSize; i++) {
                int order = columnOrder[i];
                tempMatrix[i] = matrix[order];
            }
            matrix = tempMatrix;
        }
    }
}
