package MultidimensionalArraysExercise;

import java.util.Scanner;

public class P01FillTheMatrix {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String[] result = readArray(scanner);
        int sizeOfMatrix = Integer.parseInt(result[0]);
        String typeOfMatrix = result[1];

        int[][] matrix = new int[sizeOfMatrix][sizeOfMatrix];

        if (typeOfMatrix.equals("A")) {
            matrix = typeA(sizeOfMatrix);
        } else {
            matrix = typeB(sizeOfMatrix);
        }
        printMatrix(matrix);
    }

    private static String[] readArray(Scanner scanner) {
        return scanner.nextLine().split(", ");
    }

    private static int[][] typeA(int size) {
        int count = 0;

        int[][] matrix = new int[size][size];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                count++;
                matrix[j][i] = count;
            }
        }

        return matrix;

    }

    private static int[][] typeB(int size) {
        int count = 0;

        int[][] matrix = new int[size][size];

        for (int i = 0; i < matrix.length; i++) {
            if (i % 2 == 0) {
                for (int j = 0; j < matrix[i].length; j++) {
                    count++;
                    matrix[j][i] = count;
                }
            } else {

                for (int j = matrix[i].length - 1; j >= 0; j--) {
                    count++;
                    matrix[j][i] = count;
                }
            }
        }

        return matrix;

    }

    private static void printMatrix(int[][] matrix){
        for (int[] arr: matrix) {
            for (int e: arr) {
                System.out.print(e + " ");
            }
            System.out.println();
        }
    }
}

