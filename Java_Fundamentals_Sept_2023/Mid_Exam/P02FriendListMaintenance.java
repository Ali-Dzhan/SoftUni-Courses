package Mid_Exam;

import java.util.*;
import java.util.Scanner;
import java.util.stream.Collectors;


public class P02FriendListMaintenance {
    public static void main(String[] args) {

        List<String> names = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        // Read friends' names from the first line
        String friendsLine = scanner.nextLine();
        String[] friendNames = friendsLine.split(", ");
        for (String name : friendNames) {
            names.add(name);
        }

        while (true) {
            String input = scanner.nextLine();
            if (input.equals("Report")) {
                break;
            }

            String[] tokens = input.split(" ");

            if (tokens[0].equals("Blacklist")) {
                String name = tokens[1];
                if (names.contains(name)) {
                    int index = names.indexOf(name);
                    names.set(index, "Blacklisted");
                    System.out.println(name + " was blacklisted.");
                } else {
                    System.out.println(name + " was not found.");
                }
            } else if (tokens[0].equals("Error")) {
                int index = Integer.parseInt(tokens[1]);
                if (index >= 0 && index < names.size()) {
                    String name = names.get(index);
                    if (!name.equals("Blacklisted") && !name.equals("Lost")) {
                        names.set(index, "Lost");
                        System.out.println(name + " was lost due to an error.");
                    }
                }
            } else if (tokens[0].equals("Change")) {
                int index = Integer.parseInt(tokens[1]);
                if (index >= 0 && index < names.size()) {
                    String newName = tokens[2];
                    String currentName = names.get(index);
                    names.set(index, newName);
                    System.out.println(currentName + " changed his username to " + newName + ".");
                }
            }
        }

        int blacklistedCount = (int) names.stream().filter(name -> name.equals("Blacklisted")).count();
        int lostCount = (int) names.stream().filter(name -> name.equals("Lost")).count();

        System.out.println("Blacklisted names: " + blacklistedCount);
        System.out.println("Lost names: " + lostCount);
        System.out.println(String.join(" ", names));

    }
}



