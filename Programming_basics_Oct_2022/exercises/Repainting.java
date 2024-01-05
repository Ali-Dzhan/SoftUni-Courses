package FirstStepsInCoding.Lab.exercises;

import java.util.Scanner;

public class Repainting {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double amountOfPlasticNeeded = Double.parseDouble(scanner.nextLine());
        double amountOfPaintNeeded = Double.parseDouble(scanner.nextLine());
        double amountOfThinner = Double.parseDouble(scanner.nextLine());
        double hours = Double.parseDouble(scanner.nextLine());

        int addedPlastic = 2;
        double addedPaint = amountOfPaintNeeded * 0.10;
        double plasticBags = 0.40;

        double plasticSum = (amountOfPlasticNeeded + addedPlastic) * 1.50;
        double paintSum = (amountOfPaintNeeded + addedPaint) * 14.50;
        double thinnerSum = amountOfThinner * 5.00;

        double materialSum = plasticBags + paintSum + plasticSum + thinnerSum;
        double workerPayment = (materialSum * 0.30) * hours;

        double finalResult = workerPayment + materialSum;

        System.out.println(finalResult);

    }
}
