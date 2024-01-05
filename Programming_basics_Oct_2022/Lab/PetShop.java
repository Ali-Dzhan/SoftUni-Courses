package FirstStepsInCoding.Lab.Lab;

import java.util.Scanner;

public class PetShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double packD = Double.parseDouble(scanner.nextLine());
        double packC = Double.parseDouble(scanner.nextLine());

        double dogFood = 2.50 * packD;
        double catFood = 4 * packC;

        double finalPrice = catFood + dogFood;

        System.out.printf("%f lv.", finalPrice);

    }
}
