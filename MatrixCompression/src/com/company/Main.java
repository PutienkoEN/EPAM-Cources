package com.company;

import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) {
        MyMatrix matrix = new MyMatrix();
        matrix.getMatrixFromInput(System.in);
        matrix.replaceElement();
        matrix.printMatrix();
    }

    static class MyMatrix {
        private int[][] matrix;
        private int newRow;
        private int newCol;

        public void getMatrixFromInput(InputStream stream) {
            Scanner scanner = new Scanner(stream);

            newRow = scanner.nextInt();
            newCol = scanner.nextInt();
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

        public void replaceElement() {
            MatrixElement minElement = findMinElement(newRow, newCol);

            if (minElement.getRow() != newRow){
                replaceElementCol(minElement);
            }

            if (minElement.getCol() != newCol){
                replaceElementRow(minElement);
            }

        }
        
        private MatrixElement findMinElement(int newRow, int newCol) {
            MatrixElement minElement = new MatrixElement(0, 0, matrix[0][0]);

            for (int row = 0; row < matrix.length; row++) {
                for (int col = 0; col < matrix.length; col++) {
                    if (minElement.getVal() > matrix[row][col]) {
                        minElement.set(row, col, matrix[row][col]);
                    }
                }
            }

            return minElement;
        }

        private void replaceElementRow(MatrixElement element){
            for (int row = 0; row < matrix.length; row++) {
                int tempVal = matrix[row][newCol];
                matrix[row][newCol] = matrix[row][element.getCol()];
                matrix[row][element.getCol()] = tempVal;
            }
            element.setCol(newCol);
        }

        private void replaceElementCol(MatrixElement element){
            int[] tempCol = matrix[newRow];
            matrix[newRow] = matrix[element.getRow()];
            matrix[element.getRow()] = tempCol;
            element.setRow(newRow);
        }

        static class MatrixElement {
            private int row;
            private int col;
            private int val;

            public MatrixElement(int row, int col, int val) {
                this.row = row;
                this.col = col;
                this.val = val;
            }

            public int getRow() {
                return row;
            }

            public int getCol() {
                return col;
            }

            public int getVal() {
                return val;
            }

            public void setRow(int row) {
                this.row = row;
            }

            public void setCol(int col) {
                this.col = col;
            }

            public void setVal(int val) {
                this.val = val;
            }

            public void set(int row, int col, int val) {
                this.row = row;
                this.col = col;
                this.val = val;
            }
        }
    }
}

