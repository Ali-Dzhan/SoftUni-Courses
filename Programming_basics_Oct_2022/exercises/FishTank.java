package FirstStepsInCoding.Lab.exercises;

import java.util.Scanner;

public class FishTank {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int lengthCm = Integer.parseInt(scanner.nextLine());
        int widthCm = Integer.parseInt(scanner.nextLine());
        int heightCm = Integer.parseInt(scanner.nextLine());
        double percent = Double.parseDouble(scanner.nextLine());

        double capacity = lengthCm * widthCm * heightCm;
        double capacityL = capacity * 0.001;
        double tankFullness = percent/100;

        double neededLitres = capacityL * (1-tankFullness);

        System.out.println(neededLitres);
    }
}
