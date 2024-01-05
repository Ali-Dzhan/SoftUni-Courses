package FinalExam;

import java.util.Scanner;

public class DecryptingCommands {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // Read the initial message
        String message = scanner.nextLine();

        // Process commands until "Finish" command is received
        String command;
        while (!(command = scanner.nextLine()).equals("Finish")) {
            String[] tokens = command.split("\\s+");
            String action = tokens[0];

            switch (action) {
                case "Replace":
                    char currentChar = tokens[1].charAt(0);
                    char newChar = tokens[2].charAt(0);
                    message = message.replace(currentChar, newChar);
                    System.out.println(message);
                    break;

                case "Cut":
                    int startIndex = Integer.parseInt(tokens[1]);
                    int endIndex = Integer.parseInt(tokens[2]);

                    if (isValidIndex(startIndex, message) && isValidIndex(endIndex, message)) {
                        message = message.substring(0, startIndex) + message.substring(endIndex + 1);
                        System.out.println(message);
                    } else {
                        System.out.println("Invalid indices!");
                    }
                    break;

                case "Make":
                    String caseType = tokens[1];
                    if (caseType.equals("Upper")) {
                        message = message.toUpperCase();
                    } else if (caseType.equals("Lower")) {
                        message = message.toLowerCase();
                    }
                    System.out.println(message);
                    break;

                case "Check":
                    String checkString = tokens[1];
                    if (message.contains(checkString)) {
                        System.out.println("Message contains " + checkString);
                    } else {
                        System.out.println("Message doesn't contain " + checkString);
                    }
                    break;

                case "Sum":
                    startIndex = Integer.parseInt(tokens[1]);
                    endIndex = Integer.parseInt(tokens[2]);

                    if (isValidIndex(startIndex, message) && isValidIndex(endIndex, message)) {
                        int sum = calculateAsciiSum(message.substring(startIndex, endIndex + 1));
                        System.out.println(sum);
                    } else {
                        System.out.println("Invalid indices!");
                    }
                    break;

                default:
                    System.out.println("Invalid command");
                    break;
            }
        }
    }
    private static boolean isValidIndex(int index, String message) {
        return index >= 0 && index < message.length();
    }

    private static int calculateAsciiSum(String substring) {
        int sum = 0;
        for (char ch : substring.toCharArray()) {
            sum += ch;
        }
        return sum;
    }
}

