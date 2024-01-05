package FirstStepsInCoding.Lab.exercises;

import java.util.Scanner;

public class SuppliesForSchool {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int pencilPackNumber = Integer.parseInt(scanner.nextLine());
        int markerPackNumber = Integer.parseInt(scanner.nextLine());
        int cleaningChemical = Integer.parseInt(scanner.nextLine());
        double discount = Double.parseDouble(scanner.nextLine());

        double pencilPack = 5.80;
        double markerPack = 7.20;
        double chemical = 1.20;

        double priceForPencils = pencilPackNumber * pencilPack;
        double priceForMarkers = markerPack * markerPackNumber;
        double priceForChemicals = chemical * cleaningChemical;
        double priceSum = priceForPencils + priceForMarkers + priceForChemicals;
        double priceWithDiscount = priceSum - (priceSum * (discount/100));

        System.out.println(priceWithDiscount);



    }
}
