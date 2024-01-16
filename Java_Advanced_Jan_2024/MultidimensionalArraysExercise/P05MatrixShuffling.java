package MultidimensionalArraysExercise;

import java.util.Scanner;

public class P05MatrixShuffling {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] size = readArray(scanner);

        int rows = Integer.parseInt(size[0]);
        int cols = Integer.parseInt(size[1]);

        String[][] matrix = new String[rows][cols];
        createMatrix(matrix, scanner);
        String[] commands = readLine(scanner);


        while (!commands[0].equals("END")) {
            String command = commands[0];
            if (!command.equals("swap") || commands.length != 5) {
                System.out.println("Invalid input!");
                commands = readLine(scanner);
                continue;
            }

            int row1 = Integer.parseInt(commands[1]);
            int col1 = Integer.parseInt(commands[2]);
            int row2 = Integer.parseInt(commands[3]);
            int col2 = Integer.parseInt(commands[4]);

            if (row1 >= rows || col1 >= cols || row2 >= rows || col2 >= cols) {
                System.out.println("Invalid input!");

            } else {
                String firstVariable = matrix[row1][col1];
                String secondVariable = matrix[row2][col2];
                matrix[row1][col1] = secondVariable;
                matrix[row2][col2] = firstVariable;
                printMatrix(matrix);
            }

            commands = readLine(scanner);
        }
    }

    private static void printMatrix(String[][] matrix) {
        for (String[] line : matrix) {
            for (String e : line) {
                System.out.print(e + " ");
            }
            System.out.println();
        }
    }

    private static String[] readArray(Scanner scanner) {
        return scanner.nextLine().split(" ");
    }

    private static String[] readLine(Scanner scanner) {
        return scanner.nextLine().split(" ");
    }

    private static void createMatrix(String[][] matrix, Scanner scanner) {
        for (int i = 0; i < matrix.length; i++) {
            matrix[i] = readArray(scanner);
        }
    }
}
