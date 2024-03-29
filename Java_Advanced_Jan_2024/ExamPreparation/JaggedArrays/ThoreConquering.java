package ExamPreparation.JaggedArrays;

import java.util.Scanner;

public class ThoreConquering {

    static int startRow = 0;
    static int startCol = 0;
    static int parisEnergy = 0;
    static boolean isDead = false;
    static boolean isFound = false;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        parisEnergy = Integer.parseInt(scanner.nextLine());
        int n = Integer.parseInt(scanner.nextLine());

        char[][] matrix = new char[n][n];


        for (int i = 0; i < n; i++) {
            String line = scanner.nextLine();
            matrix[i] = line.toCharArray();
            if(line.contains("P")){
                startRow = i;
                startCol = line.indexOf('P');
            }
        }

        while(parisEnergy > 0){
            String [] commandParts = scanner.nextLine().split(" ");
            String command = commandParts[0];
            String rowEnemy = commandParts[1];
            String colEnemy = commandParts[2];
            matrix = enemySpawn(matrix, Integer.parseInt(rowEnemy), Integer.parseInt(colEnemy));
            matrix = move(matrix, command, startRow, startCol);
            if(isDead || isFound){
                break;
            }
        }
        if(isFound){
            System.out.println("Paris has successfully abducted Helen! Energy left: " + parisEnergy);
        }else if(isDead){
            System.out.println("Paris died at " + startRow + ";" + startCol + ".");
        }

        printMatrix(matrix);
    }

    private static void printMatrix(char[][] matrix) {
        for (char[] arr : matrix) {
            for (char symbol : arr) {
                System.out.print(symbol);
            }
            System.out.println();
        }
    }
    private static char[][] enemySpawn(char[][] matrix, int rowEnemy, int colEnemy) {
        matrix[rowEnemy][colEnemy] = 'S';
        return matrix;
    }
    private static boolean isOutOfBounds(int row, int col, char[][] matrix) {
        return row >= matrix.length || row < 0 || col >= matrix.length || col < 0;
    }

    private static char[][] move(char[][] matrix,String command, int row, int col){
        int newRol = row;
        int newCol = col;

        switch (command) {
            case "up" -> newRol = row - 1;
            case "down" -> newRol = row + 1;
            case "left" -> newCol = col - 1;
            case "right" -> newCol = col + 1;
        }
        parisEnergy--;

        if(!isOutOfBounds(newRol, newCol, matrix)){
            matrix[row][col] = '-';
            startRow = newRol;
            startCol = newCol;

            if(matrix[startRow][startCol] == 'S'){
                parisEnergy -= 2;

                isDead = parisEnergy <= 0;

                matrix[startRow][startCol] = isDead ? 'X' : 'P';

            }else if(matrix[startRow][startCol] == 'H'){
                matrix[startRow][startCol] = '-';
                isFound = true;
            }else if(parisEnergy <= 0){
                matrix[startRow][startCol] = 'X';
                isDead = true;
            }else{
                matrix[startRow][startCol] = 'P';
            }
        }
        return matrix;
    }
}
    

