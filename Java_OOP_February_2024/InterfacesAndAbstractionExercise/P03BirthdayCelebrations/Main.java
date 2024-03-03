package InterfacesAndAbstractionExercise.P03BirthdayCelebrations;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        List<Birthable> birthables = new ArrayList<>();

        // Read input until "End" command is received
        while (true) {
            String input = scanner.nextLine();
            if (input.equals("End")) {
                break;
            }

            String[] tokens = input.split("\\s+");

            if (tokens[0].equals("Citizen")) {
                String name = tokens[1];
                int age = Integer.parseInt(tokens[2]);
                String id = tokens[3];
                String birthDate = tokens[4];
                birthables.add(new Citizen(name, age, id, birthDate));
            } else if (tokens[0].equals("Pet")) {
                String name = tokens[1];
                String birthDate = tokens[2];
                birthables.add(new Pet(name, birthDate));
            }
        }

        // Read the specific year
        int targetYear = Integer.parseInt(scanner.nextLine());

        // Print birthdates in the specified year
        for (Birthable birthable : birthables) {
            String[] birthdateTokens = birthable.getBirthDate().split("/");
            int birthYear = Integer.parseInt(birthdateTokens[2]);
            if (birthYear == targetYear) {
                System.out.println(birthable instanceof Citizen
                        ? ((Citizen) birthable).getBirthDate()
                        : ((Pet) birthable).getBirthDate());
            }
        }
    }
}
