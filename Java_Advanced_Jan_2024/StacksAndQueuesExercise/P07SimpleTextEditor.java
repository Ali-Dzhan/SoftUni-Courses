package StacksAndQueuesExercise;

import java.util.ArrayDeque;
import java.util.Scanner;

public class P07SimpleTextEditor {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());


        ArrayDeque<String> commands = new ArrayDeque<>();
        ArrayDeque<String> removedElements = new ArrayDeque<>();
        StringBuilder text = new StringBuilder();
//        ArrayDeque<String> stackforReturnCommands = new ArrayDeque<>();


        for (int i = 0; i < n; i++) {
            String rawCommand = scanner.nextLine();
            String[] commandArgs = rawCommand.split("\\s+");

            switch (commandArgs[0]) {
                case "1":
                    commands.push(rawCommand);
                    add(text, commandArgs[1]);
                    break;
                case "2":
                    commands.push(rawCommand);
                    int count = Integer.parseInt(commandArgs[1]);
                    saveDeletedElements(text,count, removedElements);
                    delete(text, count);
                    break;
                case "3":
                    int index = Integer.parseInt(commandArgs[1]);
                    System.out.println(text.charAt(index - 1));
                    break;
                case "4":
                    String lastCommands = commands.pop();
                    String[] lastCommandsArgs = lastCommands.split("\\s+");
                    String lastCommandsType = lastCommandsArgs[0];
                    if (lastCommandsType.equals("1")) {
                        int numberOfElementsToDelete = lastCommandsArgs[1].length();
                        delete(text,numberOfElementsToDelete);
                    } else {
                        add(text,removedElements.pop());
                    }
                    break;
            }


        }
    }

    private static void saveDeletedElements(StringBuilder text, int count, ArrayDeque<String> removedElements) {
        StringBuilder sb = new StringBuilder();
        for (int i = text.length()-count; i < text.length() ; i++) {
            sb.append(text.charAt(i));
        }
        removedElements.push(sb.toString());
    }

    private static void delete(StringBuilder text, int count) {
        int textLength = text.length();
        for (int i = 1; i <= count; i++) {
            text.deleteCharAt(textLength - i);
        }
    }

    private static void add(StringBuilder text, String commandArgs) {
        text.append(commandArgs);
    }
}
