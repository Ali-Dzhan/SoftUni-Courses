package MultidimensionalArraysExercise;

import java.util.Arrays;
import java.util.Scanner;

public class P02MatrixOfPalindromes {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int[] input = readArray(scanner);
        int r = input[0];
        int c = input[1];

        String[][] matrix = new String[r][c];
        fillPalindromeMatrix(matrix);
        printMatrix(matrix);
    }

    private static void fillPalindromeMatrix(String[][] matrix){
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                String outsideSymbol = String.valueOf((char) ('a' + row));
                String midSymbol = String.valueOf((char) ('a' + row + col));
                matrix[row][col] = outsideSymbol + midSymbol + outsideSymbol;
            }
        }
    }

    private static void printMatrix(String[][] matrix){
        for (String[] arr: matrix) {
            for (String e: arr) {
                System.out.print(e + " ");
            }
            System.out.println();
        }
    }

    private static int[] readArray(Scanner scanner){
        return Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
    }
}
