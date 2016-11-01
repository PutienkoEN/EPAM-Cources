package com.company;

import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) {

        MyMatrix matrix = new MyMatrix();
        matrix.getMatrixFromInput(System.in);
        matrix.findMaxLocalMaximum();
        matrix.printMaxLocalMaximum();
        matrix.printMatrix();
    }

    static class MyMatrix {
        private int matrixSize;
        private int[][] matrix;
        private int maxLocalMaximum;
        private boolean noAnswer;

        public void getMatrixFromInput(InputStream stream) {
            //Scanner scanner = new Scanner(stream);
            Scanner scanner = new Scanner("3 1 2 -1 -3 3 2 -2 0 0");

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

        public void printMaxLocalMaximum() {
            if (noAnswer == true){
                System.out.println("NOT FOUND");
            } else {
                System.out.println(maxLocalMaximum);
            }
        }

        public void findMaxLocalMaximum() {
            HashSet<Integer> maximums = new HashSet<>();

            for (int row = 0; row < matrix.length; row++) {
                for (int col = 0; col < matrix.length; col++) {
                    if (isLocalMaximum(row, col)) {
                        maximums.add(matrix[row][col]);
                    }
                }
            }

            if (maximums.size() != 0) {
                noAnswer = false;
                maxLocalMaximum = Collections.max(maximums);
            } else {
                noAnswer = true;
            }
        }

        private boolean isLocalMaximum(int elementRow, int elementCol) throws NoSuchElementException {
            int leftShift = leftOrTopBoundaries(elementRow);
            int rightShift = rightOrBotBoundaries(elementRow);
            int topShift = leftOrTopBoundaries(elementCol);
            int botShift = rightOrBotBoundaries(elementCol);

            boolean isLocalMaximum = true;
            for (int row = elementRow - leftShift; row <= elementRow + rightShift; row++) {
                for (int col = elementCol - topShift; col <= elementCol + botShift ; col++) {
                    if ((elementRow != row || elementCol != col) &&
                            matrix[elementRow][elementCol] <= matrix[row][col]) {
                        isLocalMaximum = false;
                    }
                }
            }

            return isLocalMaximum;
        }

        private int leftOrTopBoundaries(int value) {
            int shift;
            if (value == 0) {
                shift = 0;
            } else {
                shift = 1;
            }
            return shift;
        }

        private int rightOrBotBoundaries(int value) {
            int shift;

            if (value == matrix.length - 1) {
                shift = 0;
            } else {
                shift = 1;
            }
            return shift;
        }

        private int[] getCol(int colNumber) {
            int[] col = new int[matrix.length];

            for (int i = 0; i < matrix.length; i++) {
                col[i] = matrix[i][colNumber];
            }

            return col;
        }

        private void setCol(int[] col, int colNumber) {
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

        enum MySideEnum {LEFT, RIGHT, TOP, BOTTOM}
    }
}

