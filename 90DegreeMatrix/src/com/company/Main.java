package com.company;

import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) {

        MyMatrix matrix = new MyMatrix();
        matrix.getMatrixFromInput(System.in);
        matrix.rotateMatrix();
        matrix.printMatrix();
    }

    static class MyMatrix {
        private int matrixSize;
        private int[][] matrix;

        public void getMatrixFromInput(InputStream stream){
            Scanner scanner = new Scanner(stream);

            matrixSize = scanner.nextInt();

            matrix = new int[matrixSize][matrixSize];
            for (int row = 0; row < matrixSize; ++row) {
                for (int col = 0; col < matrixSize; ++col) {
                    matrix[row][col] = scanner.nextInt();
                }
            }
        }

        public void printMatrix() {
            System.out.print(matrixSize + "\n");

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
        public void rotateMatrix(){
            int[][] tempMatrix = new int[matrixSize][matrixSize];
            for (int row = 0; row < matrixSize; row++) {
                for (int col = 0; col < matrixSize; col++) {
                    tempMatrix[row][col] = matrix[col][matrixSize - 1 - row];
                }
            }

            matrix = tempMatrix;
        }
    }
}
