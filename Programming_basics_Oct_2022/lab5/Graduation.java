package FirstStepsInCoding.Lab.lab5;

import java.util.Scanner;

public class Graduation {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String name = scanner.nextLine();
        int year = 1;
        int fails = 0;
        double sum = 0;
        boolean isExcluded = false;

        while (year <= 12) {

            if (fails == 2) {
                isExcluded = true;
                System.out.printf("%s has been excluded at %d grade", name, year);
                break;
            }
            double grade = Double.parseDouble(scanner.nextLine());
            if (grade < 4) {
                fails++;
                continue;
            }
            sum += grade;
            year++;

        }
        double average = sum / 12;
        if (year >= 12) {
            System.out.printf("%s graduated. Average grade: %.2f", name, average);


        }

    }
}

