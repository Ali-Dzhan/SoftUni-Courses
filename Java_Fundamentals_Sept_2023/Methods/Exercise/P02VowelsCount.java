package Methods.Exercise;

import java.util.Locale;
import java.util.Scanner;

public class P02VowelsCount {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        System.out.println(countVowels(input));


    }

    public static int countVowels(String input){
        int counter = 0;

        input = input.toLowerCase();

        for (int i = 0; i < input.length(); i++) {
            char letter = input.charAt(i);
            if (letter == 'a' || letter == 'e' || letter == 'i' || letter == 'o'
            || letter == 'u' || letter == 'y'){
                counter++;
            }
            
        }
        return counter;
    }
}
