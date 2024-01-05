package ExamPrepFinal1;

import java.util.Scanner;

public class P08ActivationKeys{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        String command = scanner.nextLine();
        String result = input;

        while (!command.equals("Generate")) {
            String[] cmd = command.split(">>>");

            String cmd1 = cmd[0];
            String cmd2 = cmd[1];

            if (cmd1.equals("Contains") && result.contains(cmd2)) {
                System.out.println(result + " contains " + cmd2);
            } else if (cmd1.equals("Contains") && !result.contains(cmd2)) {
                System.out.println("Substring not found!");
            }

            if (cmd1.equals("Flip") && cmd2.equals("Upper")) {
                int cmd3 = Integer.parseInt(cmd[2]);
                int cmd4 = Integer.parseInt(cmd[3]);
                String editedString = result.substring(0, cmd3) +
                        result.substring(cmd3, cmd4).toUpperCase() +
                        result.substring(cmd4);
                System.out.println(editedString);
                result = editedString;
            } else if (cmd1.equals("Flip") && cmd2.equals("Lower")) {
                int cmd3 = Integer.parseInt(cmd[2]);
                int cmd4 = Integer.parseInt(cmd[3]);
                String editedString = result.substring(0, cmd3) +
                        result.substring(cmd3, cmd4).toLowerCase() +
                        result.substring(cmd4);
                System.out.println(editedString);
                result = editedString;
            }

            if (cmd1.equals("Slice")) {
                int cmd3 = Integer.parseInt(cmd[1]);
                int cmd4 = Integer.parseInt(cmd[2]);
                result = processSlice(result, cmd3, cmd4);
            }

            command = scanner.nextLine();
        }

        System.out.println("Your activation key is: " + result);

        // Close the scanner to prevent resource leaks
        scanner.close();
    }
    private static String processSlice(String rawActivationKey, int startIndex, int endIndex) {
        StringBuilder modifiedKey = new StringBuilder(rawActivationKey);
        modifiedKey.delete(startIndex, endIndex);

        System.out.println(modifiedKey);
        return modifiedKey.toString();
    }
}