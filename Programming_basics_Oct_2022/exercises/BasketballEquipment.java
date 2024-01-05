package FirstStepsInCoding.Lab.exercises;

import java.util.Scanner;

public class BasketballEquipment {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int yearlyTax = Integer.parseInt(scanner.nextLine());

        double sneakersPrice = yearlyTax - (yearlyTax * 0.40);
        double clothesPrice = sneakersPrice - (sneakersPrice * 0.20);
        double ballPrice = clothesPrice * 0.25;
        double accessoriesPrice = ballPrice * 0.20;

        double finalPrice = sneakersPrice + clothesPrice + ballPrice + accessoriesPrice + yearlyTax;

        System.out.println(finalPrice);
    }
}
