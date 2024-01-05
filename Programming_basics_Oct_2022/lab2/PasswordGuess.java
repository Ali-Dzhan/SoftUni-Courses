package FirstStepsInCoding.Lab.lab2;

import java.util.Scanner;

public class PasswordGuess {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String password = scanner.nextLine();
        String correctPassword = "s3cr3t!P@ssw0rd";

        if (password.equals(correctPassword)) {
            System.out.println("Welcome");
        } else {
            System.out.println("Wrong password!");


        }
    }
}
