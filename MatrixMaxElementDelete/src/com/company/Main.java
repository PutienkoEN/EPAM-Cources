package com.company;

import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) {
        MyMatrix matrix = new MyMatrix();
        matrix.getMatrixFromInput(System.in);
        matrix.removeMaxRowsColumns();
        matrix.printMatrix();
    }

    static class MyMatrix {
        private int[][] matrix;

        public void getMatrixFromInput(InputStream stream) {
            Scanner scanner = new Scanner("3 1 2 3 4 5 6 7 8 9");

            int matrixSize = scanner.nextInt();

            matrix = new int[matrixSize][matrixSize];
            for (int row = 0; row < matrixSize; ++row) {
                for (int col = 0; col < matrixSize; ++col) {
                    matrix[row][col] = scanner.nextInt();
                }
            }
        }

        public void printMatrix() {
            System.out.print(matrix.length + "\n");
            System.out.print(matrix[0].length + "\n");

            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[i].length; j++) {
                    System.out.print(matrix[i][j]);
                    if (j != matrix[i].length - 1) {
                        System.out.print("\t");
                    } else {
                        System.out.print("\n");
                    }
                }
            }
        }

        public void removeMaxRowsColumns() {
            int maxElement = findMaxElementValue();
            findRowsAndColsWithElement(maxElement);

        }

        private int findMaxElementValue() {
            int maxElementValue = matrix[0][0];

            for (int row = 0; row < matrix.length; row++) {
                for (int col = 0; col < matrix.length; col++) {
                    if (matrix[row][col] > maxElementValue) {
                        maxElementValue = matrix[row][col];
                    }
                }
            }
            return maxElementValue;
        }

        private void findRowsAndColsWithElement(int elementValue) {
            ArrayList<Integer> rowsToDelete = new ArrayList<>();
            ArrayList<Integer> colsToDelete = new ArrayList<>();

            for (int row = 0; row < matrix.length; row++) {
                for (int col = 0; col < matrix.length; col++) {
                    if (matrix[row][col] == elementValue) {
                        if (!rowsToDelete.contains(row)){
                            rowsToDelete.add(row);
                        }

                        if (!colsToDelete.contains(col)){
                            colsToDelete.add(col);
                        }
                    }
                }
            }

            int newRowSize = matrix.length - rowsToDelete.size();
            int newColSize = matrix.length - colsToDelete.size();
            int[][] tempMatrix = new int[newRowSize][newColSize];

            int tempRow = 0;
            int tempCol;
            for (int row = 0; row < matrix.length; row++) {
                if (!rowsToDelete.contains(row)) {
                    tempCol = 0;
                    for (int col = 0; col < matrix.length; col++) {
                        if (!colsToDelete.contains(col)){
                            tempMatrix[tempRow][tempCol] = matrix[row][col];
                            tempCol++;
                        }
                    }
                    tempRow++;
                }
            }

            matrix = tempMatrix;
        }
    }
}

