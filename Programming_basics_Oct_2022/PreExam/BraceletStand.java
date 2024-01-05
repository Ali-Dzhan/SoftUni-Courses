package FirstStepsInCoding.Lab.PreExam;

import java.util.Scanner;

public class BraceletStand {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        double budget = Double.parseDouble(scanner.nextLine());
        double profitFromSales = Double.parseDouble(scanner.nextLine());
        double expenses = Double.parseDouble(scanner.nextLine());
        double gift = Double.parseDouble(scanner.nextLine());

        double pocketMoney = budget * 5;
        double SalesMoney = profitFromSales * 5;
        double savedMoney = pocketMoney + SalesMoney;

        double moneyWithExpenses = savedMoney - expenses;

        if (moneyWithExpenses >= gift){
            System.out.printf("Profit: %.2f BGN, the gift has been purchased.", moneyWithExpenses);
        }else{
            double neededMoney = gift - moneyWithExpenses;
            System.out.printf("Insufficient money: %.2f BGN.", neededMoney);
        }

    }
}
