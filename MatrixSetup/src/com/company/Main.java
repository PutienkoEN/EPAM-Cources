package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int matrixSize = getMatrixSize();
        int[][] matrix = setMatrix(matrixSize);
        printMatrix(matrix);
    }

    private static int getMatrixSize() {
        int matrixSize = 0;
        try (Scanner input = new Scanner(System.in)) {
            if (input.hasNextInt()) {
                matrixSize = input.nextInt();
            }
        }

        return matrixSize;
    }

    private static int[][] setMatrix(int matrixSize) {
        int[][] matrix = new int[matrixSize][matrixSize];
        for (int i = 0; i < matrixSize; i++) {
            for (int j = 0; j < matrixSize; j++) {
                matrix[i][j] = i * matrixSize + j + 1;
            }
        }
        return matrix;
    }

    private static void printMatrix(int[][] matrix) {
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
}
