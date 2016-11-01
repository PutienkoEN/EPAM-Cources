package com.company;

import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) {

        MyMatrix matrix = new MyMatrix();
        matrix.getMatrixFromInput(System.in);
        matrix.replaceZeroes();
        matrix.printMatrix();
    }

    static class MyMatrix {
        private int matrixSize;
        private int[][] matrix;

        public void getMatrixFromInput(InputStream stream) {
            Scanner scanner = new Scanner("3 0 0 3 4 5 6 7 0 9");

            matrixSize = scanner.nextInt();

            matrix = new int[matrixSize][matrixSize];
            for (int row = 0; row < matrixSize; ++row) {
                for (int col = 0; col < matrixSize; ++col) {
                    matrix[row][col] = scanner.nextInt();
                }
            }
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

        public void replaceZeroes() {
            int[][] tempMatrix = new int[matrix.length][matrix.length];

            for (int row = 0; row < matrix.length; row++) {
                int[] tempRow = getRow(row);
                tempMatrix[row] = sortRow(tempRow);
            }

            matrix = tempMatrix;
        }

        private int[] sortRow(int[] row) {
            for (int i = row.length - 1; i >=0 ; i--) {
                if (row[i] == 0) {
                    row = moveZeroToEnd(row, i);
                }
            }

            return row;
        }

        private int[] moveZeroToEnd(int row[], int indexOfZeroElement) {
            int[] tempRow = new int[row.length];
            int iterator = 0;
            for (int i = 0; i < row.length; i++) {
                tempRow[iterator] = row[i];
                if (i != indexOfZeroElement) {
                    iterator++;
                }
            }
            tempRow[tempRow.length - 1] = 0;

            return tempRow;
        }

        private int[] getCol(int colNumber) {
            int[] col = new int[matrix.length];

            for (int i = 0; i < matrix.length; i++) {
                col[i] = matrix[i][colNumber];
            }

            return col;
        }

        private int[] getRow(int getRow) {
            return matrix[getRow];
        }

    }
}

