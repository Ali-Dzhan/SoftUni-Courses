package FirstStepsInCoding.Lab.lab4;

import java.util.Scanner;

public class CharacterSequence {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();

        for( int i = 0; i < text.length(); i++){
            System.out.println(text.charAt(i));
        }
    }
}
