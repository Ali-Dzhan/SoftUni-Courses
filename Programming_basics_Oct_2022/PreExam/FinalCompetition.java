package FirstStepsInCoding.Lab.PreExam;

import java.util.Scanner;

public class FinalCompetition {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int dancers = Integer.parseInt(scanner.nextLine());
        double points = Double.parseDouble(scanner.nextLine());
        String season = scanner.nextLine();
        String place = scanner.nextLine();

        double profit = dancers * points;

        if (place.equals("Abroad")) {
            profit *= 1.50;
        }

        switch (season) {

            case "summer":
                if (place.equals("Bulgaria")) {
                    profit *= 0.95;
                } else if (place.equals("Abroad")) {
                    profit *= 0.90;
                }
                break;
            case "winter":
                if (place.equals("Bulgaria")) {
                    profit *= 0.92;
                } else if (place.equals("Abroad")) {
                    profit *= 0.85;
                }
                break;

        }
        double charity = profit * 0.25;
        double leftMoney = profit - charity;
        double dancerMoney = charity / dancers;

        System.out.printf("Charity - %.2f%n",leftMoney );
        System.out.printf("Money per dancer - %.2f",dancerMoney);
    }
}
