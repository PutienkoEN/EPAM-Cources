package com.company;

import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) {

        MyMatrix matrix = new MyMatrix();
        matrix.getMatrixFromInput(System.in);
        matrix.calculate();
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

        public void calculate() {
            int result = 0;
            if (matrix.length < 4) {
                result = calculateDeterminant(matrix);
            } else {
                for (int row = 0; row < matrix.length; row++) {
                    int[][] tempMatrix = getSmallerMatrix(matrix, row, 0);
                    int det = calculateDeterminant(tempMatrix);
                    int sign = (int) Math.pow(-1, row);
                    int multiplier = matrix[row][0];

                    result += sign * multiplier * det;
                }
            }
            System.out.print(result);
        }

        public int[][] getSmallerMatrix(int[][] secondaryMatrix, int rowToRemove, int colToRemove) {
            int[][] tempMatrix = new int[secondaryMatrix.length - 1][secondaryMatrix.length - 1];

            int tempRow = 0;
            for (int row = 0; row < secondaryMatrix.length; row++) {
                if (row != rowToRemove) {
                    int temCol = 0;
                    for (int col = 0; col < secondaryMatrix.length; col++) {
                        if (col != colToRemove) {
                            tempMatrix[tempRow][temCol] = secondaryMatrix[row][col];
                            temCol++;
                        }
                    }
                    tempRow++;
                }
            }

            return tempMatrix;
        }

        public int calculateDeterminant(int[][] secondaryMatrix) {
            int plusValues = 0;
            int minusValues = 0;
            int[] valuesPl = new int[secondaryMatrix.length];
            int[] valuesMin = new int[secondaryMatrix.length];

            for (int row = 0; row < secondaryMatrix.length; row++) {
                int plusValue = 1;
                int minusValue = 1;
                for (int col = 0; col < secondaryMatrix.length; col++) {

                    int currentPlusRow = col + row;
                    if (currentPlusRow > secondaryMatrix.length - 1) {
                        currentPlusRow -= secondaryMatrix.length;
                    }
                    plusValue *= secondaryMatrix[col][currentPlusRow];

                    int currentMinusRow = row + col;
                    if (currentMinusRow > secondaryMatrix.length - 1) {
                        currentMinusRow -= secondaryMatrix.length;
                    }
                    minusValue *= secondaryMatrix[secondaryMatrix.length - 1 - col][currentMinusRow];
                }
                valuesMin[row] = plusValue;
                valuesPl[row] = minusValue;

                plusValues += plusValue;
                minusValues += minusValue;
            }

            return (plusValues - minusValues);
        }
    }
}
