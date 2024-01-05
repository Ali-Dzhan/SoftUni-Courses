package FirstStepsInCoding.Lab.exercise5;

import java.util.Scanner;

public class Vacation {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        double neededMoney = Double.parseDouble(scanner.nextLine());
        double ownedMoney = Double.parseDouble(scanner.nextLine());

        int daysCount = 0;
        int spendingCount = 0;

        while(ownedMoney < neededMoney && spendingCount < 5){
            String command = scanner.nextLine();
            double money = Double.parseDouble(scanner.nextLine());
            daysCount ++;

            if (command.equals("save")){
                ownedMoney += money;
                spendingCount = 0;
            } else if (command.equals("spend")) {
                ownedMoney -= money;
                spendingCount += 1;
                if (ownedMoney <0){
                    ownedMoney = 0;
                }
                
            }
        }
        if (spendingCount ==5 ){
            System.out.println("You can't save the money.");
            System.out.println(daysCount);
        }
        if (ownedMoney >= neededMoney){
            System.out.printf("You saved the money for %d days.", daysCount);
        }

    }
}
