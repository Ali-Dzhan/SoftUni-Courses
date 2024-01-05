package FirstStepsInCoding.Lab.exercises;

import java.util.Scanner;

public class VacationBooksList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

       int pageNumbers = Integer.parseInt(scanner.nextLine());
       int pagesPerHour = Integer.parseInt(scanner.nextLine());
       int daysToRead = Integer.parseInt(scanner.nextLine());

       int readingTimeSum = pageNumbers / pagesPerHour;
       int numberOfHoursPerDay = readingTimeSum / daysToRead;

        System.out.println(numberOfHoursPerDay);

    }
}
