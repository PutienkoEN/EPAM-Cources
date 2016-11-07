package com.company;

import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) {

        MyMatrix matrix = new MyMatrix();
        matrix.getMatrixFromInput(System.in);
        matrix.countSeddlePoints();
        matrix.printSeddlePointsCount();
    }

    static class MyMatrix {
        private int matrixSize;
        private int[][] matrix;
        private int seddlePointCount = 0;

        public void getMatrixFromInput(InputStream stream) {
            Scanner scanner = new Scanner("2\n" +
                    "0\t1\n" +
                    "-1\t2");

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

        public void printSeddlePointsCount() {
            System.out.println(seddlePointCount);
        }

        public void countSeddlePoints() {
            ArrayList<Vector2> minRowPoints = getMinRowPoints();
            ArrayList<Vector2> maxColPoints = getMaxColPoints();

            for (int i = 0; i < minRowPoints.size(); i++) {
                Vector2 minRowPoint = minRowPoints.get(i);

                for (int j = 0; j < maxColPoints.size(); j++) {
                    Vector2 maxRowPoint = maxColPoints.get(j);

                    if (minRowPoint.equals(maxRowPoint)) {
                        seddlePointCount++;
                    }

                }
            }

        }

        private ArrayList<Vector2> getMinRowPoints() {
            ArrayList<Vector2> minRowPoints = new ArrayList<>();

            for (int i = 0; i < matrix.length; i++) {
                int[] row = getRow(i);
                int minRowElementIndex = minElementIndex(row);

                if (elementUnique(minRowElementIndex, row)) {
                    minRowPoints.add(new Vector2(i, minRowElementIndex));
                }
            }

            return minRowPoints;
        }

        private ArrayList<Vector2> getMaxColPoints() {
            ArrayList<Vector2> maxColPoints = new ArrayList<>();

            for (int i = 0; i < matrix.length; i++) {
                int[] col = getCol(i);
                int maxColElementIndex = maxElementIndex(col);

                if (elementUnique(maxColElementIndex, col)) {
                    maxColPoints.add(new Vector2(maxColElementIndex, i));
                }
            }

            return maxColPoints;
        }

        private boolean elementUnique(int index, int[] array) {
            int elementValue = array[index];
            boolean elementUnique = true;

            for (int i = 0; i < array.length; i++) {
                if (array[i] == elementValue && index != i) {
                    elementUnique = false;
                }
            }

            return elementUnique;
        }

        private int minElementIndex(int[] array) {
            int minElement = array[0];
            int minElementIndex = 0;

            for (int i = 0; i < array.length; i++) {
                if (minElement > array[i]) {
                    minElement = array[i];
                    minElementIndex = i;
                }
            }

            return minElementIndex;
        }

        private int maxElementIndex(int[] array) {
            int maxElement = array[0];
            int maxElementIndex = 0;
            for (int i = 0; i < array.length; i++) {
                if (maxElement > array[i]) {
                    maxElement = array[i];
                    maxElementIndex = i;
                }
            }

            return maxElementIndex;

        }

        class Vector2 {
            private int row;
            private int col;

            public Vector2(int row, int col) {
                this.row = row;
                this.col = col;
            }

            public int getRow() {
                return row;
            }

            public int getCol() {
                return col;
            }

            @Override
            public boolean equals(Object o) {
                if (this == o) return true;
                if (o == null || getClass() != o.getClass()) return false;

                Vector2 vector2 = (Vector2) o;

                if (row != vector2.row) return false;
                return col == vector2.col;

            }

            @Override
            public int hashCode() {
                int result = row;
                result = 31 * result + col;
                return result;
            }
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


    }
}

