package FirstStepsInCoding.Lab.exercises;

import java.util.Scanner;

public class FoodDelivery {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int chickenMenu = Integer.parseInt(scanner.nextLine());
        int fishMenu = Integer.parseInt(scanner.nextLine());
        int veganMenu = Integer.parseInt(scanner.nextLine());

        double chickenMenuPrice = chickenMenu * 10.35;
        double fishMenuPrice = fishMenu * 12.40;
        double veganMenuPrice = veganMenu * 8.15;

        double menuSum = chickenMenuPrice + fishMenuPrice + veganMenuPrice;
        double desertPrice = menuSum * 0.20;
        double deliveryPrice = 2.50;
        double finalPrice = deliveryPrice + desertPrice + menuSum;

        System.out.println(finalPrice);
    }
}
