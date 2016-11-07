package com.company;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) {

        MyMatrix matrix = new MyMatrix();
        matrix.getMatrixFromInput(System.in);
        matrix.roundMatrix();
        matrix.printMatrix();
    }

    static class MyMatrix {
        private int matrixSize;
        private double[][] matrix;

        public void getMatrixFromInput(InputStream stream) {
            //Scanner scanner = new Scanner("3 -2,42 1,0 -2,99 0,54 0,0 3,0 -1,5 1,89 2,0");
            Scanner scanner = new Scanner(stream);
            matrixSize = scanner.nextInt();

            matrix = new double[matrixSize][matrixSize];
            for (int row = 0; row < matrixSize; ++row) {
                for (int col = 0; col < matrixSize; ++col) {
                    matrix[row][col] = scanner.nextDouble();
                }
            }
        }

        public void printMatrix() {
            System.out.print(matrixSize + "\n\n");
            DecimalFormat df = new DecimalFormat();

            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[i].length; j++) {
                    System.out.print(df.format(matrix[i][j]));
                    if (j != matrix[i].length - 1) {
                        System.out.print("\t");
                    } else {
                        System.out.print("\n\n");
                    }
                }
            }
        }

        public void roundMatrix() {
            for (int row = 0; row < matrix.length; row++) {
                for (int col = 0; col < matrix.length; col++) {
                    matrix[row][col] = roundElementWithMath(matrix[row][col]);
                }
            }
        }

        private double roundElementWithMath(double element) {
            return Math.rint(element);
        }
    }
}

