package FirstStepsInCoding.Lab.exercises2;

import java.util.Scanner;

public class Shopping {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double budget = Double.parseDouble(scanner.nextLine());
        int graphicsCardsNumber = Integer.parseInt(scanner.nextLine());
        int processorsNumber = Integer.parseInt(scanner.nextLine());
        int ramMemoryNumber = Integer.parseInt(scanner.nextLine());

        double graphicCard = graphicsCardsNumber * 250;
        double processorPrice = graphicCard * 0.35;
        double processor = processorPrice * processorsNumber;
        double ramMemoryPrice = graphicCard * 0.10;
        double ramMemory = ramMemoryPrice * ramMemoryNumber;

        double discount;
        double sum = graphicCard + processor + ramMemory;

        if (graphicsCardsNumber>processorsNumber){
            discount = 0.15 * sum;
        } else {
            discount = 0;

        }
        double finalPrice = sum - discount;

        if (finalPrice<=budget){
            double moneyLeft=budget-finalPrice;
            System.out.printf("You have %.2f leva left!", moneyLeft);

        } else {
            double moneyNeeded = finalPrice - budget;
            System.out.printf("Not enough money! You need %.2f leva more!", moneyNeeded);
        }
    }
}
