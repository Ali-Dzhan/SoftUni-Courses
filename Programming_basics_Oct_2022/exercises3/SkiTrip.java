package FirstStepsInCoding.Lab.exercises3;

import java.util.Scanner;

public class SkiTrip {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int days = Integer.parseInt(scanner.nextLine());
        String roomType = scanner.nextLine();
        String rating = scanner.nextLine();

        int overnightStays = days - 1;
        double price = 0;

        switch (roomType) {
            case "room for one person":
                price = overnightStays * 18.00;
                if (rating.equals("positive")) {
                    price = price + (price * 0.25);
                } else if (rating.equals("negative")) {
                    price = price * 0.90;

                }
                break;
            case "apartment":
                price = overnightStays * 25.00;
                if (overnightStays < 9) {
                    price = price * 0.70;

                } else if (overnightStays < 14) {
                    price = price * 0.65;

                } else {
                    price = price * 0.50;
                }
                if (rating.equals("positive")) {
                    price = price + (price * 0.25);
                } else if (rating.equals("negative")) {
                    price = price * 0.90;


                }
                break;
            case "president apartment":
                price = overnightStays * 35.00;
                if (overnightStays < 9) {
                    price = price * 0.90;

                } else if (overnightStays < 14) {
                    price = price * 0.85;

                } else {
                    price = price * 0.80;
                }
                if (rating.equals("positive")) {
                    price = price + (price * 0.25);
                } else if (rating.equals("negative")) {
                    price = price * 0.90;


                }
                break;
        }
        System.out.printf("%.2f", price);
    }
}
