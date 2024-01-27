package FunctionalProgrammingExercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

public class P04AppliedArithmetics {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> nums = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        Function<List<Integer>, List<Integer>> add = list -> list.stream()
                .map(e -> e + 1)
                .collect(Collectors.toList());

        Function<List<Integer>, List<Integer>> multiply = list -> list.stream()
                .map(e -> e * 2)
                .collect(Collectors.toList());

        Function<List<Integer>, List<Integer>> subtract = list -> list.stream()
                .map(e -> e - 1)
                .collect(Collectors.toList());

        Consumer<List<Integer>> print = list -> list.forEach(e -> System.out.print(e + " "));

        String command = scanner.nextLine();

        while (!"end".equals(command)) {
            switch (command) {
                case "add":
                    nums = add.apply(nums);
                    break;
                case "multiply":
                    nums = multiply.apply(nums);
                    break;
                case "subtract":
                    nums = subtract.apply(nums);
                    break;
                case "print":
                    print.accept(nums);
                    System.out.println();
                    break;
            }

            command = scanner.nextLine();
        }

    }
}
