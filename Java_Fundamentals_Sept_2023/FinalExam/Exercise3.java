package FinalExam;

import java.util.*;

public class Exercise3 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Map<String, List<String>> heroesList = new LinkedHashMap<>();
        String input = scanner.nextLine();

        while (!input.equals("End")) {
            String[] splitInput = input.split("\\s+");
            String command = splitInput[0];

            if (command.equals("Enroll")) {
                String name = splitInput[1];
                if (!heroesList.containsKey(name)) {
                    heroesList.put(name, new ArrayList<>());
                } else {
                    System.out.println(name + " is already enrolled.");
                }
            }

            if (command.equals("Learn")) {
                String name = splitInput[1];
                String spell = splitInput[2];
                if (heroesList.containsKey(name)) {
                    if (!heroesList.get(name).contains(spell)) {
                        heroesList.get(name).add(spell);
                    } else {
                        System.out.println(name + " has already learnt " + spell + ".");
                    }
                } else {
                    System.out.println(name + " doesn't exist.");
                }
            }

            if (command.equals("Unlearn")) {
                String name = splitInput[1];
                String spell = splitInput[2];
                if (heroesList.containsKey(name)) {
                    if (heroesList.get(name).contains(spell)) {
                        heroesList.get(name).remove(spell);
                    } else {
                        System.out.println(name + " doesn't know " + spell + ".");
                    }
                } else {
                    System.out.println(name + " doesn't exist.");
                }
            }

            input = scanner.nextLine();
        }

        System.out.println("Heroes:");

       /* heroesList.entrySet().stream()
                .sorted(Map.Entry.<String, List<String>>comparingByValue(Comparator.comparingInt(List::size))
                        .reversed()
                        .thenComparing(Map.Entry.comparingByKey()))
                .forEach(entry -> {
                    System.out.print("== " + entry.getKey() + ": ");
                    System.out.println(String.join(", ", entry.getValue()));
                });

        */
        for (Map.Entry<String, List<String>> entry : heroesList.entrySet()) {
            System.out.print("== " + entry.getKey() + ": ");
            System.out.println(String.join(", ", entry.getValue()));
        }

    }
}
