package com.company;

import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) {

        MyMatrix matrix = new MyMatrix();
        matrix.getMatrixFromInput(System.in);
        matrix.printMatrix();
        matrix.orderRows();
        matrix.printMatrix();
    }

    static class MyMatrix {
        private int matrixSize;
        private int[][] matrix;

        public void getMatrixFromInput(InputStream stream) {
            Scanner scanner = new Scanner("3 7 5 -1 4 -2 6 0 0 -5");

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

        public void orderRows() {
            Map<Integer, Integer> rowsOrder = new TreeMap<>();

            for (int rowNumber = 0; rowNumber < matrix.length; rowNumber++) {
                int[] col = getRow(rowNumber);
                int rowValue = calculateRowValue(col);
                rowsOrder.put(rowValue, rowNumber);
            }

            Map<Integer, Integer> sortedOrder = new TreeMap<>();
            sortedOrder.putAll(rowsOrder);

            int newMatrixIterator = 0;
            int[][]tempMatrix = new int[matrix.length][matrix.length];
            for (Integer i : sortedOrder.keySet()) {
                int rowNumber = sortedOrder.get(i);
                for (int j = 0; j < matrix.length ; j++) {
                    tempMatrix[newMatrixIterator][j] = matrix[rowNumber][j];
                }
                newMatrixIterator++;
            }
            matrix = tempMatrix;
        }

        private int calculateRowValue (int[] col){
            int sumOfElements = 0;
            for (int i = 0; i < col.length; i++) {
                sumOfElements += col[i];
            }
            return sumOfElements;
        }

        private void changeColsPlaces(int firstColIndex, int secondColIndex) {
            int[] firstCol = getCol(firstColIndex);
            int[] secondCol = getCol(secondColIndex);
            setCol(firstCol, secondColIndex);
            setCol(secondCol, firstColIndex);
        }

        private int[] getCol(int colNumber) {
            int[] col = new int[matrix.length];

            for (int i = 0; i < matrix.length; i++) {
                col[i] = matrix[i][colNumber];
            }

            return col;
        }

        private void setCol (int[] col, int colNumber) {
            for (int i = 0; i < matrix.length; i++) {
                matrix[i][colNumber] = col[i];
            }
        }

        private int[] getRow(int getRow) {
            return matrix[getRow];
        }

        private void setRow(int[] row, int rowNumber) {
            matrix[rowNumber] = row;
        }


    }
}

