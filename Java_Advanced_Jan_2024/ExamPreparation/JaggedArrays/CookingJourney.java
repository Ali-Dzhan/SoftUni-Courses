package ExamPreparation.JaggedArrays;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CookingJourney {

    static int rowOfPlayer = 0;
    static int colOfPlayer = 0;
    static List<int[]> listOfPillars = new ArrayList<>();
    static boolean isOut = false;
    static int moneyCollected = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // size of the square matrix
        int n = Integer.parseInt(scanner.nextLine());

        char[][] matrix = new char[n][n];

        for (int i = 0; i < n; i++) {
            String line = scanner.nextLine();
            matrix[i] = line.toCharArray();
            if(line.contains("S")){
                 rowOfPlayer = i;
                 colOfPlayer = line.indexOf('S');
            }
            if(line.contains("P")){
                for (int j = 0; j < line.length(); j++) {
                    if (line.charAt(j) == 'P') {
                        int[] positionsOfPillar = new int[]{i, j};
                        listOfPillars.add(positionsOfPillar);
                    }
                }
            }
        }

        while(!isOut && moneyCollected < 50){
            String command = scanner.nextLine();
            move(command, matrix);
        }

        if(isOut){
            System.out.println("Bad news! You are out of the pastry shop.");
        }else if(moneyCollected >= 50){
            System.out.println("Good news! You succeeded in collecting enough money!");
        }
        System.out.printf("Money: %d\n", moneyCollected);
        printMatrix(matrix);
    }

    // method for moving the player in the matrix

    private static void move(String command, char[][] matrix){
        int newRow = rowOfPlayer;
        int newCol = colOfPlayer;

        // moving
        switch (command) {
            case "up" -> newRow -= 1;
            case "down" -> newRow += 1;
            case "left" -> newCol -= 1;
            case "right" -> newCol += 1;
        }

        //check if he is out
        if(isOutOfBounds(newRow, newCol, matrix)){
            matrix[rowOfPlayer][colOfPlayer] = '-';
            isOut = true;
        }else{
            if(Character.isDigit(matrix[newRow][newCol])){
                String digit = "" + matrix[newRow][newCol];
                moneyCollected += Integer.parseInt(digit);
                matrix[newRow][newCol] = 'S';
                matrix[rowOfPlayer][colOfPlayer] = '-';
                rowOfPlayer = newRow;
                colOfPlayer = newCol;
            }else if(matrix[newRow][newCol] == 'P'){
                int rowOfOtherPillar = newRow;
                int colOfOtherPillar = newCol;
                for(int [] arr : listOfPillars){
                    if(arr[0] != newRow && arr[1] != newCol){
                        rowOfOtherPillar = arr[0];
                        colOfOtherPillar = arr[1];
                    }
                }
                matrix[newRow][newCol] = '-';
                matrix[rowOfPlayer][colOfPlayer] = '-';
                matrix[rowOfOtherPillar][colOfOtherPillar] = 'S';
                rowOfPlayer = rowOfOtherPillar;
                colOfPlayer = colOfOtherPillar;
            }else if(matrix[newRow][newCol] == '-'){
                matrix[newRow][newCol] = 'S';
                matrix[rowOfPlayer][colOfPlayer] = '-';
                rowOfPlayer = newRow;
                colOfPlayer = newCol;
            }
        }
    }

    // boolean method to check if the player is in bounds

    private static boolean isOutOfBounds(int row, int col, char[][] matrix){
        return  row >= matrix.length || row < 0 || col >= matrix.length || col < 0;
    }

    // method for printing the square matrix with a foreach
      private static void printMatrix(char[][] matrix) {
          for (char[] arr : matrix) {
              for (char symbol : arr) {
                  System.out.print(symbol);
              }
              System.out.println();
          }
      }
}
