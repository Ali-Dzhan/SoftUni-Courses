package FirstStepsInCoding.Lab.exercises3;

import java.util.Scanner;

public class NewHouse {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String flowers = scanner.nextLine();
        int countFlowers = Integer.parseInt(scanner.nextLine());
        int budget = Integer.parseInt(scanner.nextLine());


        double price = 0;

        switch (flowers) {
            case "Roses":
                price = countFlowers * 5;
                if (countFlowers > 80) {
                    price = price - price * 0.1; //price * 0.9;
                }

                break;
            case "Dahlias":
                price = countFlowers * 3.80;
                if (countFlowers > 90) {
                    price = price - price * 0.15;// price * 0.85
                }
                break;
            case "Tulips":
                price = countFlowers * 2.80;

                if (countFlowers > 80) {
                    price = price - price * 0.15; // price * 0.85
                }
                break;
            case "Narcissus":
                price = countFlowers * 3;
                if (countFlowers < 120) {
                    price = price + price * 0.15; // price * 1.15
                }
                break;
            case "Gladiolus":
                price = countFlowers * 2.50;
                if (countFlowers < 80) {
                    price = price + price * 0.2; // price * 1.20
                }
                break;
        }
        double difference = Math.abs(budget - price);

        if (price <= budget) {

            System.out.printf("Hey, you have a great garden with %d %s and %.2f leva left.", countFlowers, flowers, difference);
        } else {
            System.out.printf("Not enough money, you need %.2f leva more.", difference);
        }


    }
}


