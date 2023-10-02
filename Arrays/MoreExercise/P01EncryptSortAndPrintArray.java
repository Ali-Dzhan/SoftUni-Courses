package Arrays.MoreExercise;

import java.util.Arrays;
import java.util.Scanner;

public class P01EncryptSortAndPrintArray {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        int sumVowels = 0;
        int sumConsonant = 0;
        int sum = 0;

        int[] arrOfSums = new int[n];

        for (int i = 0; i < n; i++) {
            
            String name = scanner.nextLine();
            for (int j = 0; j < name.length(); j++) {

                int currentLetter = name.charAt(j);
                if (currentLetter == 97
                        || currentLetter == 101
                        || currentLetter == 105
                        || currentLetter == 111
                        || currentLetter == 117
                        || currentLetter == 65
                        || currentLetter == 69
                        || currentLetter == 73
                        || currentLetter == 79
                        || currentLetter ==85)
                {
                    sumVowels += currentLetter * name.length();
                }
                else
                {
                    sumConsonant += currentLetter / name.length();
                }
                
            }
            sum = sumVowels + sumConsonant;
            arrOfSums[i] = sum;

            sumVowels = 0;
            sumConsonant = 0;
            sum = 0;

        }
        Arrays.sort(arrOfSums);
        for (int i = 0; i < arrOfSums.length; i++) {
            System.out.println(arrOfSums[i]);
            
        }
    }
}
