package ExamPrepMid;

import java.util.Scanner;
public class P01ComputerStore {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String client = scanner.nextLine();

        double priceWithoutTax = 0;
        double tax = 0;
        double sumTax = 0;
        double totalPrice = 0;

        while(!client.equals("special") && !client.equals("regular")) {
            double price = Double.parseDouble(client);

            if (price < 0) {
                System.out.println("Invalid price!");
                client = scanner.nextLine();
            } else {

                priceWithoutTax = priceWithoutTax + price;
                tax = 0.2 * price;
                sumTax = sumTax + tax;
                totalPrice = totalPrice + (price * 1.2);

                client = scanner.nextLine();

            }
            if (client.equals("special")) {

                totalPrice = totalPrice * (0.9);

                System.out.println("Congratulations you've just bought a new computer!");
                System.out.printf("Price without taxes: %.2f$\n", priceWithoutTax);
                System.out.printf("Taxes: %.2f$\n", sumTax);
                System.out.println("-----------");
                System.out.printf("Total price: %.2f$", totalPrice);


            } else if (client.equals("regular")) {

                System.out.println("Congratulations you've just bought a new computer!");
                System.out.printf("Price without taxes: %.2f$\n", priceWithoutTax);
                System.out.printf("Taxes: %.2f$\n", sumTax);
                System.out.println("-----------");
                System.out.printf("Total price: %.2f$", totalPrice);

                }
            }
        if(totalPrice < 0 || totalPrice == 0){
            System.out.println("Invalid order!");
        }

    }
}
