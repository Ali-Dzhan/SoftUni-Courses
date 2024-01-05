package FirstStepsInCoding.Lab.exercises;

import java.util.Scanner;

public class DepositCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double depositAmount = Double.parseDouble(scanner.nextLine());
        int months = Integer.parseInt(scanner.nextLine());

        double interestRate = Double.parseDouble(scanner.nextLine());

        double profitPerMonth = (depositAmount * (interestRate/100))/12;

        double totalSum = depositAmount + profitPerMonth * months;

        System.out.println(totalSum);
    }
}
