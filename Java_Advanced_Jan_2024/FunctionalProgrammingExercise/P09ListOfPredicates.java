package FunctionalProgrammingExercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class P09ListOfPredicates {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder output = new StringBuilder();

        int n = Integer.parseInt(scanner.nextLine());

        List<Integer> numbersToDevideTo = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        Predicate<Integer> isDivisible = number -> {
            for (Integer numberToDevide : numbersToDevideTo) {
                if (number % numberToDevide != 0) {
                    return false;
                }
            }
            return true;
        };

        for (int number = 1; number <= n; number++) {
            if (isDivisible.test(number)) {
                output.append(number).append(" ");
            }
        }

        System.out.println(output);
    }
}
