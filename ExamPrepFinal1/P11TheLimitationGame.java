package ExamPrepFinal1;

import java.util.Scanner;

public class P11TheLimitationGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read the encrypted message
        StringBuilder encryptedMessage = new StringBuilder(scanner.nextLine());

        // Process instructions until "Decode" command is given
        String command;
        while (!(command = scanner.nextLine()).equals("Decode")) {
            String[] tokens = command.split("\\|");

            switch (tokens[0]) {
                case "Move":
                    int numberOfLetters = Integer.parseInt(tokens[1]);
                    encryptedMessage.append(encryptedMessage.substring(0, numberOfLetters)).delete(0, numberOfLetters);
                    break;
                case "Insert":
                    int index = Integer.parseInt(tokens[1]);
                    String value = tokens[2];
                    encryptedMessage.insert(index, value);
                    break;
                case "ChangeAll":
                    String substring = tokens[1];
                    String replacement = tokens[2];
                    int changeIndex = encryptedMessage.indexOf(substring);
                    while (changeIndex != -1) {
                        encryptedMessage.replace(changeIndex, changeIndex + substring.length(), replacement);
                        changeIndex = encryptedMessage.indexOf(substring, changeIndex + replacement.length());
                    }
                    break;
                default:
                    System.out.println("Invalid command: " + command);
            }
        }

        // Print the decrypted message
        System.out.println("The decrypted message is: " + encryptedMessage);
    }
}

