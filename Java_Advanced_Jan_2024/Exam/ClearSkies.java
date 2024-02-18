package Exam;

import java.util.Scanner;

public class ClearSkies {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        String[][] matrix = new String[n][n];

        fillMatrix(scanner, matrix);

        int[] coordinates = findCoordinates(matrix, "J");
        int jetRow = coordinates[0];
        int jetCol = coordinates[1];

        int countEnemy = 4; // Initialize with the total number of enemies
        int armour = 300;

        while (countEnemy > 0) {
            String command = scanner.nextLine();
            matrix[jetRow][jetCol] = "-"; // Mark the current position as empty

            // Move
            switch (command) {
                case "up" -> jetRow--;
                case "down" -> jetRow++;
                case "left" -> jetCol--;
                case "right" -> jetCol++;
            }

            // Check new position
            String position = matrix[jetRow][jetCol];

            if ("E".equals(position)) {
                countEnemy--;
                armour -= 100;

                if (armour <= 0) {

                    System.out.println("Mission failed, your jetfighter was shot down! Last coordinates" +
                            " [" + jetRow + ", " + jetCol + "]!");
                    matrix[jetRow][jetCol] = "J";
                    break;
                }
            } else if ("R".equals(position)) {
                armour = 300;
            }

            matrix[jetRow][jetCol] = "J"; // Mark the new position of the jetfighter
        }

        if (countEnemy == 0) {
            System.out.println("Mission accomplished, you neutralized the aerial threat!");
        }

        print(matrix);
    }

    private static void print(String[][] matrix) {
        for (String[] row : matrix) {
            for (String cell : row) {
                System.out.print(cell + "");
            }
            System.out.println();
        }
    }

    private static void fillMatrix(Scanner scanner, String[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            String[] currentRow = scanner.nextLine().split("");
            for (int col = 0; col < currentRow.length; col++) {
                matrix[row][col] = currentRow[col];
            }
        }
    }

    private static int[] findCoordinates(String[][] field, String symbol) {
        int[] coordinates = new int[2];

        for (int row = 0; row < field.length; row++) {
            for (int col = 0; col < field[row].length; col++) {
                if (symbol.equals(field[row][col])) {
                    coordinates[0] = row;
                    coordinates[1] = col;
                    break;
                }
            }
        }

        return coordinates;
    }
}
