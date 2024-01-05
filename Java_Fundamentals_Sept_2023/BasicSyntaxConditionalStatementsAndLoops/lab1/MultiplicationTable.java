package BasicSyntaxConditionalStatementsAndLoops.lab1;

import java.util.Scanner;

public class MultiplicationTable {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());

        int counter=1;


        while(counter<=10){
            int result = counter * number;
            System.out.printf("%d X %d = %d%n", number, counter, result);
            counter +=1;
        }
    }
}
