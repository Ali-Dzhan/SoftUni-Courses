package FirstStepsInCoding.Lab.PreExam;

import java.util.Scanner;

public class BestPlayer {
    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);

        String command = scanner.nextLine();

        String footballerWithMostGoals = "";
        int mostGoalsScored = 0;

        while (!command.equals("END")) {

            String footballerName = command;
            int goals = Integer.parseInt(scanner.nextLine());

            if (goals > mostGoalsScored) {
                mostGoalsScored = goals;
                footballerWithMostGoals = footballerName;
            }
            if (mostGoalsScored >= 10) {
                break;
            }
            command = scanner.nextLine();
        }

        System.out.printf("%s is the best player!%n", footballerWithMostGoals);

        if (mostGoalsScored >= 3) {
            System.out.printf("He has scored %d goals and made a hat-trick !!!", mostGoalsScored);
        } else {
            System.out.printf("He has scored %d goals.", mostGoalsScored);
        }
    }
}

