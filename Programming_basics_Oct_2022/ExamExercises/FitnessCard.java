package FirstStepsInCoding.Lab.ExamExercises;

import java.util.Scanner;

public class FitnessCard {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        double budget = Double.parseDouble(scanner.nextLine());
        String gender = scanner.nextLine();
        int age = Integer.parseInt(scanner.nextLine());
        String sport = scanner.nextLine();

        double cardPrice = 0;

        switch (gender) {
            case "m":
                if (sport.equals("Gym")) {
                    cardPrice = 42;
                } else if (sport.equals("Boxing")) {
                    cardPrice = 41;
                } else if (sport.equals("Yoga")) {
                    cardPrice = 45;
                } else if (sport.equals("Zumba")) {
                    cardPrice = 34;
                } else if (sport.equals("Dances")) {
                    cardPrice = 51;
                } else if (sport.equals("Pilates")) {
                    cardPrice = 39;
                }
                break;
            case "f":
                if (sport.equals("Gym")) {
                    cardPrice = 35;
                } else if (sport.equals("Boxing")) {
                    cardPrice = 37;
                } else if (sport.equals("Yoga")) {
                    cardPrice = 42;
                } else if (sport.equals("Zumba")) {
                    cardPrice = 31;
                } else if (sport.equals("Dances")) {
                    cardPrice = 53;
                } else if (sport.equals("Pilates")) {
                    cardPrice = 37;
                }
                break;
        }
        if (age <= 19) {
            cardPrice = cardPrice - (cardPrice * 0.20);
        }
        if (cardPrice>budget){
            double neededMoney = cardPrice - budget;
            System.out.printf("You don't have enough money! You need $%.2f more.", neededMoney);
        } else if (budget >= cardPrice) {
            System.out.printf("You purchased a 1 month pass for %s.", sport);

        }
    }
}








