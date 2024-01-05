package FirstStepsInCoding.Lab.exercise4;

import java.util.Scanner;

public class TennisRankList {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int countTournaments = Integer.parseInt(scanner.nextLine());
        int initialPoints = Integer.parseInt(scanner.nextLine());
        int sumPoints = initialPoints;
        int countWins = 0;

        for (int i = 1; i <= countTournaments; i++) {
            String tournamentStage = scanner.nextLine();

            if (tournamentStage.equals("W")) {
                sumPoints += 2000;
                countWins++;
            } else if (tournamentStage.equals("F")) {
                sumPoints += 1200;

            } else if (tournamentStage.equals("SF")) {
                sumPoints += 720;


            }
        }
        int tournamentPoints = sumPoints - initialPoints;
        double percent = (1.0 * countWins/countTournaments) *100;

        System.out.printf("Final points: %d%n",sumPoints);
        System.out.printf("Average points: %d%n", tournamentPoints/countTournaments);
        System.out.printf("%.2f%%",percent);
    }
}