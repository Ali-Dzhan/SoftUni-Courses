package FirstStepsInCoding.Lab.exercises3;

import java.util.Scanner;

public class FishingBoat {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int budget = Integer.parseInt(scanner.nextLine());
        String season = scanner.nextLine();
        int fishermen = Integer.parseInt(scanner.nextLine());

        double priceForBoat = 0.0;
        double bonusDiscount = 0.95;
        double priceForBoatWithDiscount = 0.0;
        double moneyLeft = 0;
        double moneyNeeded = 0;

        switch (season) {
            case "Spring":
                priceForBoat = 3000;
                if (fishermen <= 6) {
                    priceForBoatWithDiscount = priceForBoat * 0.90;
                } else if (fishermen <= 11) {
                    priceForBoatWithDiscount = priceForBoat * 0.85;

                } else {
                    priceForBoatWithDiscount = priceForBoat * 0.75;


                }
                if (fishermen % 2 == 0) {

                    priceForBoatWithDiscount = priceForBoatWithDiscount * bonusDiscount;
                } else {
                    bonusDiscount = 0;

                }
                break;
            case "Summer":
                priceForBoat = 4200;
                if (fishermen <= 6) {
                    priceForBoatWithDiscount = priceForBoat * 0.90;
                } else if (fishermen <= 11) {
                    priceForBoatWithDiscount = priceForBoat * 0.85;

                } else {
                    priceForBoatWithDiscount = priceForBoat * 0.75;


                }
                if (fishermen % 2 == 0) {

                    priceForBoatWithDiscount = priceForBoatWithDiscount * bonusDiscount;
                } else {
                    bonusDiscount = 0;

                }
                break;
            case "Autumn":
                priceForBoat = 4200;
                if (fishermen <= 6) {
                    priceForBoatWithDiscount = priceForBoat * 0.90;
                } else if (fishermen <= 11) {
                    priceForBoatWithDiscount = priceForBoat * 0.85;

                } else {
                    priceForBoatWithDiscount = priceForBoat * 0.75;

                }
                break;
            case "Winter":
                priceForBoat = 2600;
                if (fishermen <= 6) {
                    priceForBoatWithDiscount = priceForBoat * 0.90;
                } else if (fishermen <= 11) {
                    priceForBoatWithDiscount = priceForBoat * 0.85;

                } else {
                    priceForBoatWithDiscount = priceForBoat * 0.75;


                }
                if (fishermen % 2 == 0) {

                    priceForBoatWithDiscount = priceForBoatWithDiscount * bonusDiscount;
                } else {
                    bonusDiscount = 0;

                }
                break;


        }
        if (priceForBoatWithDiscount <= budget) {
            moneyLeft = budget - priceForBoatWithDiscount;
            System.out.printf("Yes! You have %.2f leva left.", moneyLeft);
        } else {
            moneyNeeded = priceForBoatWithDiscount - budget;
            System.out.printf("Not enough money! You need %.2f leva.", moneyNeeded);
        }
    }
}
