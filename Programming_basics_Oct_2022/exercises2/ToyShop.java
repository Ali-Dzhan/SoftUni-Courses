package FirstStepsInCoding.Lab.exercises2;

import java.util.Scanner;

public class ToyShop {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        double tripPrice= Double.parseDouble(scanner.nextLine());
        int puzzles = Integer.parseInt(scanner.nextLine());
        int talkingDolls = Integer.parseInt(scanner.nextLine());
        int plushyBears = Integer.parseInt(scanner.nextLine());
        int minions = Integer.parseInt(scanner.nextLine());
        int trucks = Integer.parseInt(scanner.nextLine());

        double toys = puzzles + talkingDolls + plushyBears + minions + trucks;
        double sum  = (puzzles * 2.60) + (talkingDolls * 3) + (plushyBears *4.10) + (minions * 8.20) + (trucks * 2);

        double discount;

        if (toys>=50){
            discount = 0.25 * sum;

        } else {
            discount = 0;

        }
        double finalSum = sum - discount;
        double rent = 0.10 * finalSum;
        double profit = finalSum - rent;

        double money;

        if (tripPrice<=profit) {
            money = profit - tripPrice;
            System.out.printf("Yes! %.2f lv left.", money);

        } else {
            money = tripPrice - profit;
            System.out.printf("Not enough money! %.2f lv needed.", money);

        }

        }


    }

