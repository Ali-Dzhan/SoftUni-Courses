package Mid_Exam;

import java.util.Scanner;

public class P01TheHuntingGames {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int days = scanner.nextInt();
        int players = scanner.nextInt();
        double totalEnergy = scanner.nextDouble();
        double personWater = scanner.nextDouble();
        double personFood = scanner.nextDouble();
        double totalWater = days * players * personWater;
        double totalFood = days * players * personFood;
        int waterDay = 0;
        int foodDay = 0;

        for (int day = 0; day < days; day++) {
            double wastedEnergy = scanner.nextDouble();
            totalEnergy -= wastedEnergy;

            if (totalEnergy <= 0.0) {
                break;
            }

            waterDay += 1;

            if (waterDay >= 2) {
                totalWater -= totalWater * 0.3;
                totalEnergy += totalEnergy * 0.05;
                waterDay = 0;
            }

            foodDay += 1;

            if (foodDay >= 3) {
                totalFood -= totalFood / players;
                totalEnergy += totalEnergy * 0.1;
                foodDay = 0;
            }
        }

        if (totalEnergy >= 1) {
            System.out.printf("You are ready for the quest. You will be left with - %.2f energy!%n", totalEnergy);
        } else {
            System.out.printf("You will run out of energy. You will be left with %.2f food and %.2f water.%n", totalFood, totalWater);
        }
    }
}
