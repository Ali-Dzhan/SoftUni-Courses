package FinalExam;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Exercise2 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine();
            processMessage(input);
        }
    }

    private static void processMessage(String input) {
        String regex = "^!(?<command>[A-Z][a-z]+)!:\\[(?<message>[A-Za-z]{8,})\\]$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);

        if (matcher.matches()) {
            String command = matcher.group("command");
            String message = matcher.group("message");

            encryptAndPrint(command, message);
        } else {
            System.out.println("The message is invalid");
        }
    }

    private static void encryptAndPrint(String command, String message) {
        System.out.print(command + ":");
        for (int i = 0; i < message.length(); i++) {
            System.out.print(" " + (int) message.charAt(i));
        }
        System.out.println();
    }
}
