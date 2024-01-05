package FinalExam;

import java.util.Scanner;

public class Exercise1 {
    public static void main(String[] args) {
       /* Scanner scanner = new Scanner(System.in);

        StringBuilder message = new StringBuilder(scanner.nextLine());

        StringBuilder newMessage = new StringBuilder(message.toString());

        String command = scanner.nextLine();
        while (!command.equals("Finish")) {
            String[] tokens = command.split("\\s+");
            String action = tokens[0];

            switch (action) {
                case "Replace":
                    String currentStr = tokens[1];
                    String newStr = tokens[2];
                    int index = message.indexOf(currentStr);
                    while (index != -1) {
                        newMessage.replace(index, index + currentStr.length(), newStr);
                        index = message.indexOf(currentStr, index + newStr.length());
                    }
                    System.out.println(newMessage);
                    break;
                case "Make":
                    String caseType = tokens[1];

                    if (caseType.equals("Upper")) {
                        newMessage = new StringBuilder(message.toString().toUpperCase());

                        System.out.println(newMessage);
                    } else if (caseType.equals("Lower")) {
                        newMessage = new StringBuilder(message.toString().toLowerCase());

                        System.out.println(newMessage);
                    }
                    break;

                case "Check":
                    String substring = tokens[1];
                    if (newMessage.toString().contains(substring)) {
                        System.out.println("Message contains " + substring);
                    } else {
                        System.out.println("Message doesn't contain " + substring);
                    }
                    break;

                case "Sum":
                    int startIndex = Integer.parseInt(tokens[1]);
                    int endIndex = Integer.parseInt(tokens[2]);
                    if (startIndex >= 0 && endIndex < newMessage.length() && startIndex <= endIndex) {
                        int sum = 0;
                        for (int i = startIndex; i <= endIndex; i++) {
                            sum += newMessage.charAt(i);
                        }
                        System.out.println(sum);
                    } else {
                        System.out.println("Invalid indices!");
                    }
                    break;

                case "Cut":
                    int cutStartIndex = Integer.parseInt(tokens[1]);
                    int cutEndIndex = Integer.parseInt(tokens[2]);
                    if (cutStartIndex >= 0 && cutEndIndex < newMessage.length() && cutStartIndex <= cutEndIndex) {
                        message.delete(cutStartIndex, cutEndIndex + 1);
                    } else {
                        System.out.println("Invalid indices!");
                    }
                    break;
            }



            command = scanner.nextLine();
        }

        */

        Scanner scanner = new Scanner(System.in);

        StringBuilder message = new StringBuilder(scanner.nextLine());

        String command;
        while (!(command = scanner.nextLine()).equals("Finish")) {
            String[] tokens = command.split("\\s+");

            switch (tokens[0]) {
                case "Replace":
                    char currentChar = tokens[1].charAt(0);
                    char newChar = tokens[2].charAt(0);
                    for (int i = 0; i < message.length(); i++) {
                        if (message.charAt(i) == currentChar) {
                            message.setCharAt(i, newChar);
                        }
                    }
                    System.out.println(message);
                    break;

                case "Cut":
                    int startIndex = Integer.parseInt(tokens[1]);
                    int endIndex = Integer.parseInt(tokens[2]);
                    if (isValidIndex(startIndex, message) && isValidIndex(endIndex, message)) {
                        message.delete(startIndex, endIndex + 1);
                        System.out.println(message);
                    } else {
                        System.out.println("Invalid indices!");
                    }
                    break;

                case "Make":
                    if (tokens[1].equals("Upper")) {
                        message = new StringBuilder(message.toString().toUpperCase());
                    } else if (tokens[1].equals("Lower")) {
                        message = new StringBuilder(message.toString().toLowerCase());
                    }
                    System.out.println(message);
                    break;

                case "Check":
                    String substring = tokens[1];
                    if (message.toString().contains(substring)) {
                        System.out.println("Message contains " + substring);
                    } else {
                        System.out.println("Message doesn't contain " + substring);
                    }
                    break;

                case "Sum":
                    startIndex = Integer.parseInt(tokens[1]);
                    endIndex = Integer.parseInt(tokens[2]);
                    if (isValidIndex(startIndex, message) && isValidIndex(endIndex, message)) {
                        int sum = 0;
                        for (int i = startIndex; i <= endIndex; i++) {
                            sum += message.charAt(i);
                        }
                        System.out.println(sum);
                    } else {
                        System.out.println("Invalid indices!");
                    }
                    break;

                default:
                    System.out.println("Invalid command!");
                    break;
            }
        }
    }

    private static boolean isValidIndex(int index, StringBuilder message) {
        return index >= 0 && index < message.length();
    }
}
