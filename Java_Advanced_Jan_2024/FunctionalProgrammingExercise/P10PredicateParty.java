package FunctionalProgrammingExercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class P10PredicateParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Predicate<String> predicate;

        List<String> guests = Arrays.stream(scanner.nextLine().split(" "))
                .collect(Collectors.toList());

        String line = scanner.nextLine();

        while (!"Party!".equals(line)) {
            String citeria = line.split("\\s+")[2];
            if (line.contains("StartsWith")) {
                predicate = s -> s.startsWith(citeria);
            } else if (line.contains("EndsWith")) {
                predicate = s -> s.endsWith(citeria);
            } else {
                predicate = s -> s.length() == Integer.parseInt(citeria);
            }

            if (line.contains("Remove")) {
                guests.removeIf(predicate);

            } else {
                List<String> guestToDouble = guests.stream()
                        .filter(predicate)
                        .collect(Collectors.toList());
                guests.addAll(guestToDouble);
            }
            line = scanner.nextLine();
        }

        if (guests.size() == 0) {
            System.out.println("Nobody is going to the party!");
        } else {
            String output = guests.stream().sorted().collect(Collectors.joining(", "));
            System.out.println(output + " are going to the party!");
        }
    }
}
