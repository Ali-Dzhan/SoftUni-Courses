package BasicSyntaxConditionalStatementsAndLoops.Exercise1;

import java.util.Scanner;

public class PrintAndSum {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int firstNumber = Integer.parseInt(sc.nextLine());
        int endNumber =Integer.parseInt(sc.nextLine());

        int sum = 0;

        if(firstNumber <= endNumber) {
            for (int i = firstNumber; i <= endNumber ; i++) {
                System.out.print(i + " ");
                sum += i;
            }
            } else {
                for (int i = firstNumber; i >= endNumber; i--) {
                    System.out.print(i + " ");
                    sum += i;
                }
            }

            System.out.println();
            System.out.println("Sum: " + sum);
        }
        }


