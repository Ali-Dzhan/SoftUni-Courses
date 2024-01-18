package SetsAndMaps;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class P09Largest3Numbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Read a list of integers

        String input = scanner.nextLine();
        String[] strNumbers = input.split(" ");

        // Convert string array to List<Integer>
        List<Integer> numbers = new ArrayList<>();
        for (String strNumber : strNumbers) {
            numbers.add(Integer.parseInt(strNumber));
        }

        // Sort the list in descending order
        Collections.sort(numbers, Collections.reverseOrder());

        // Print the largest three integers or all of them if less than three
        int limit = Math.min(3, numbers.size());
        for (int i = 0; i < limit; i++) {
            System.out.print(numbers.get(i) + " ");
        }


    }
}
