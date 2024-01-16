package MultidimensionalArraysExercise;

import java.util.Arrays;
import java.util.Scanner;

public class P04MaximalSum {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int[] sizes = readArray(scanner);
        int rows = sizes[0];
        int cols = sizes[1];

        int[][] matrix = new int[rows][cols];
        createMatrix(matrix, scanner);

        int maxSum = Integer.MIN_VALUE;
        int rowIndex = 0;
        int colIndex = 0;
        for (int i = 0; i < rows - 2; i++) {

            for (int j = 0; j < cols - 2; j++) {
                int sum = matrix[i][j] + matrix[i][j + 1] + matrix[i][j + 2] +
                        matrix[i + 1][j] + matrix[i + 1][j + 1] + matrix[i + 1][j + 2] +
                        matrix[i + 2][j] + matrix[i + 2][j + 1] + matrix[i + 2][j + 2];

                if (sum > maxSum) {
                    maxSum = sum;
                    rowIndex = i;
                    colIndex = j;
                }
            }
        }
        System.out.println("Sum = " + maxSum);
        printMatrix(matrix, rowIndex, colIndex);

    }

    private static int[] readArray(Scanner scanner) {
        return Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
    }

    private static void createMatrix(int[][] matrix, Scanner scanner) {
        for (int i = 0; i < matrix.length; i++) {
            matrix[i] = readArray(scanner);
        }

    }

    private static void printMatrix(int[][] matrix, int rowIndex, int colIndex) {
        for (int row = rowIndex; row < rowIndex + 3; row++) {
            for (int col = colIndex; col < colIndex+3; col++) {
                System.out.print(matrix[row][col]+" ");
            }
            System.out.println();
        }
    }
}
