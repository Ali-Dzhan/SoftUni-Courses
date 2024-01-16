package MultidimensionalArraysExercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class P07CrossFire {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String[] dimensions = scanner.nextLine().split(" ");
        int rows = Integer.parseInt(dimensions[0]);
        int cols = Integer.parseInt(dimensions[1]);
        List<List<Integer>> matrix = new ArrayList<>();

        fillMatrix(matrix, rows, cols, scanner);

        String commmand = scanner.nextLine();
        while (!"Nuke it from orbit".equals(commmand)){
            int targetRow = Integer.parseInt(commmand.split(" ")[0]);
            int targetColumn = Integer.parseInt(commmand.split(" ")[1]);
            int targetRadius = Integer.parseInt(commmand.split(" ")[2]);


            for (int row = targetRow-targetRadius; row <= targetRow +targetRadius; row++) {
                if(inSide(matrix, row, targetColumn)){
                    matrix.get(row).set(targetColumn,0);
                }
            }
            for (int col = targetColumn-targetRadius; col <= targetColumn +targetRadius; col++) {
                if(inSide(matrix, targetRow, col)){
                    matrix.get(targetRow).set(col,0);
                }
            }
            for (int row = 0; row < matrix.size(); row++) {
                List<Integer> currentRow=  matrix.get(row);
                currentRow.removeAll(List.of(0));
                if(matrix.get(row).size() ==0){
                    matrix.remove(row);
                    row--;
                }
            }
            commmand = scanner.nextLine();
        }

        printMatrix(matrix);
    }

    private static boolean inSide(List<List<Integer>> matrix, int row, int col) {
        return row>=0 && row < matrix.size() && col >= 0 && col <matrix.get(row).size();
    }


    private static void printMatrix(List<List<Integer>> matrix) {
        for (List<Integer> row : matrix) {
            row.forEach(e -> System.out.print(e + " "));
            System.out.println();
        }
    }

    private static void fillMatrix(List<List<Integer>> matrix, int rows, int cols, Scanner scanner) {
        int cunter = 1;
        for (int row = 0; row < rows; row++) {
            ArrayList<Integer> numbers = new ArrayList<>();
            for (int col = 0; col < cols; col++) {
                numbers.add(cunter++);
            }
            matrix.add(numbers);
        }

    }
}
