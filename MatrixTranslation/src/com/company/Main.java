package com.company;

import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) {

        MyMatrix matrix = new MyMatrix();
        matrix.getMatrixFromInput(System.in);
        matrix.shiftMatrix();
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
        private int matrixShift;
        private int[][] matrix;

        public void getMatrixFromInput(InputStream stream) {
            Scanner scanner = new Scanner(stream);

            matrixShift = scanner.nextInt();
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

        public void shiftMatrix() {
            int[][] tempMatrix = new int[matrixSize][matrixSize];
            for (int i = 0; i < matrixSize; i++) {
                int newPosition = calculateShift(i, matrixShift);
                tempMatrix[newPosition] = matrix[i];
            }
            matrix = tempMatrix;
        }

        private int calculateShift(int startPos, int shift) {
            int newPositionInArray;
            int relativePosition = startPos + shift % matrixSize;

            if (relativePosition >= 0 && relativePosition < matrixSize) {
                newPositionInArray = relativePosition;
            } else if (relativePosition >= matrixSize) {
                newPositionInArray = relativePosition - matrixSize;
            } else {
                newPositionInArray = matrixSize + relativePosition;
            }

            return newPositionInArray;
        }
    }
}

