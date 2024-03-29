package ExamPreparation.JaggedArrays;

import java.util.Scanner;

public class Bomb {

    static int rowOfPlayer = 0;
    static int colOfPlayer = 0;
    static boolean isReachEndPoint = false;
    static int countBombs = 0;
    static int foundBombs = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int sizeOfMatrix = Integer.parseInt(scanner.nextLine());
        String [] commands = scanner.nextLine().split(",");
        char [][] matrix = new char[sizeOfMatrix][sizeOfMatrix];

        for (int i = 0; i < sizeOfMatrix; i++) {
            String line = scanner.nextLine();
            matrix[i] = new char[sizeOfMatrix];
            int index = 0;
            for (int j = 0; j < line.length(); j++) {
                if(line.charAt(j) != ' '){
                    matrix[i][index++] = line.charAt(j);
                }
            }
            for(int k = 0; k < matrix[i].length; k++){
                if(matrix[i][k] == 's'){
                    rowOfPlayer = i;
                    colOfPlayer = k;
                }
                if(matrix[i][k] == 'B'){
                    countBombs++;
                }
            }

        }
        int numberCommand = -1;
        while (!isReachEndPoint && ++numberCommand < commands.length && countBombs > foundBombs){
            String command = commands[numberCommand];
            move(command, matrix);
            if(isReachEndPoint){
                break;
            }
        }
        if(foundBombs == countBombs){
            System.out.println("Congratulations! You found all bombs!");
        }else if(isReachEndPoint){
            System.out.printf("END! %d bombs left on the field", countBombs - foundBombs);
        }else{
            System.out.printf("%d bombs left on the field. Sapper position: (%d,%d)",
                    countBombs- foundBombs, rowOfPlayer, colOfPlayer);
        }
    }

    private static void move(String command, char[][] matrix) {
        int newRow = rowOfPlayer;
        int newCol = colOfPlayer;

        switch (command) {
            case "up" -> newRow -= 1;
            case "down" -> newRow += 1;
            case "left" -> newCol -= 1;
            case "right" -> newCol += 1;
        }
        if(!isOutOfBounds(newRow, newCol, matrix)){
            if(matrix[newRow][newCol] == 'e'){
                isReachEndPoint = true;
            }else if(matrix[newRow][newCol] == 'B'){
                System.out.println("You found a bomb!");
                foundBombs++;
            }
            matrix[rowOfPlayer][colOfPlayer] = '+';
            matrix[newRow][newCol] = 's';
            rowOfPlayer = newRow;
            colOfPlayer = newCol;
        }
    }

    private static boolean isOutOfBounds(int row, int col, char[][] matrix) {
        return row >= matrix.length || row < 0 || col >= matrix.length || col < 0;
    }

}
