package FirstStepsInCoding.Lab.exercises3;

import java.util.Scanner;

public class HotelRoom {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String month = scanner.nextLine();
        int countNights = Integer.parseInt(scanner.nextLine());

        double priceForApartment = 0;
        double priceForStudio = 0;

        switch (month) {
            case "May":
            case "October":
                priceForApartment = countNights * 65;
                priceForStudio = countNights * 50;
                if (countNights > 7 && countNights <= 14) {
                    priceForStudio = priceForStudio - priceForStudio * 0.05;

                } else if (countNights > 14) {
                    priceForStudio = priceForStudio - priceForStudio * 0.3;
                    priceForApartment = priceForApartment - priceForApartment * 0.1;

                }

                break;

            case "June":
            case "September":

                priceForApartment = countNights * 68.70;
                priceForStudio = countNights * 75.20;
                if (countNights > 14) {
                    priceForStudio = priceForStudio - priceForStudio * 0.2;
                    priceForApartment = priceForApartment - priceForApartment * 0.1;

                }


                break;
            case "July":
            case "August":
                priceForApartment = countNights * 77;
                priceForStudio = countNights * 76;
                if (countNights > 14) {
                    priceForApartment = priceForApartment - priceForApartment * 0.1;
                }

                break;
        }
        System.out.printf("Apartment: %.2f lv.%n", priceForApartment);
        System.out.printf("Studio: %.2f lv.", priceForStudio);


    }
}
