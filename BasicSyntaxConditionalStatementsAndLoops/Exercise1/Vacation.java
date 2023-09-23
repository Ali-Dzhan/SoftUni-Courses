package BasicSyntaxConditionalStatementsAndLoops.Exercise1;

import java.util.Scanner;

public class Vacation {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int group = Integer.parseInt(sc.nextLine());
        String people = sc.nextLine();
        String day = sc.nextLine();

        double price = 0;

        double totalPriceS = 0;

        double totalPrice = 0;

        switch (people) {
            case "Students":
                if (day.equals("Friday")) {
                    price = 8.45;
                    if (group >= 30) {
                        totalPriceS = price - price * 0.15;
                        totalPrice = totalPriceS * group;
                        System.out.printf("Total price: %.2f", totalPrice);
                    } else {

                        totalPrice = price * group;
                        System.out.printf("Total price: %.2f", totalPrice);
                    }
                } else if (day.equals("Saturday")) {
                    price = 9.80;
                    if (group >= 30) {
                        totalPriceS = price - price * 0.15;
                        totalPrice = totalPriceS * group;
                        System.out.printf("Total price: %.2f", totalPrice);
                    } else {

                        totalPrice = price * group;
                        System.out.printf("Total price: %.2f", totalPrice);
                    }

                } else if (day.equals("Sunday")) {
                    price = 10.46;
                    if (group >= 30) {
                        totalPriceS = price - price * 0.15;
                        totalPrice = totalPriceS * group;
                        System.out.printf("Total price: %.2f", totalPrice);
                    } else {

                        totalPrice = price * group;
                        System.out.printf("Total price: %.2f", totalPrice);
                    }
                }
                break;
            case "Business":
                if (day.equals("Friday")) {
                    price = 10.90;
                    if (group >= 100) {
                        group -= 10;
                        totalPriceS = price;
                        totalPrice = totalPriceS * group;
                        System.out.printf("Total price: %.2f", totalPrice);
                    } else {

                        totalPrice = price * group;
                        System.out.printf("Total price: %.2f", totalPrice);
                    }
                } else if (day.equals("Saturday")) {
                    price = 15.60;
                    if (group >= 100) {
                        group -= 10;
                        totalPriceS = price;
                        totalPrice = totalPriceS * group;
                        System.out.printf("Total price: %.2f", totalPrice);
                    } else {

                        totalPrice = price * group;
                        System.out.printf("Total price: %.2f", totalPrice);
                    }

                } else if (day.equals("Sunday")) {
                    price = 16;
                    if (group >= 100) {
                        group -= 10;
                        totalPriceS = price;
                        totalPrice = totalPriceS * group;
                        System.out.printf("Total price: %.2f", totalPrice);
                    } else {

                        totalPrice = price * group;
                        System.out.printf("Total price: %.2f", totalPrice);
                    }
                }
                break;
            case "Regular":
                if (day.equals("Friday")) {
                    price = 15;
                    if (group >= 10 && group <= 20) {
                        totalPriceS = price - price * 0.05;
                        totalPrice = totalPriceS * group;
                        System.out.printf("Total price: %.2f", totalPrice);
                    } else {

                        totalPrice = price * group;
                        System.out.printf("Total price: %.2f", totalPrice);
                    }
                } else if (day.equals("Saturday")) {
                    price = 20;
                    if (group >= 10 && group <= 20) {
                        totalPriceS = price - price * 0.05;
                        totalPrice = totalPriceS * group;
                        System.out.printf("Total price: %.2f", totalPrice);
                    } else {
                        totalPrice = price * group;
                    }
                    System.out.printf("Total price: %.2f", totalPrice);

                } else if (day.equals("Sunday")) {
                    price = 22.50;
                    if (group >= 10 && group <= 20) {
                        totalPriceS = price - price * 0.05;
                        totalPrice = totalPriceS * group;
                        System.out.printf("Total price: %.2f", totalPrice);
                    } else {

                        totalPrice = price * group;
                        System.out.printf("Total price: %.2f", totalPrice);
                    }
                    break;
                }
        }
    }
}
