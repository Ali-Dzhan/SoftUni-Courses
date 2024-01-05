package DataTypesAndVariables.Exercise;

import java.util.Scanner;

public class P04SumOfChars {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int countSymbols= Integer.parseInt(scanner.nextLine());
        int sum = 0;

        for (int i = 1; i <=countSymbols ; i++) {
            char symbol = scanner.nextLine().charAt(0);
            sum += (int)symbol;

        }
        System.out.printf("The sum equals: %d",sum);
    }
}
