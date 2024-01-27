package FunctionalProgrammingExercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class P05ReverseAndExclude {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> nums = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        int divisible = Integer.parseInt(scanner.nextLine());

        Consumer<List<Integer>> reverseRemoveDivisibleAndPrint = (arr) ->
                arr.reversed()
                        .stream()
                        .filter(s -> s % divisible != 0)
                        .forEach(s -> System.out.print(s + " "));

        reverseRemoveDivisibleAndPrint.accept(nums);
    }
}
