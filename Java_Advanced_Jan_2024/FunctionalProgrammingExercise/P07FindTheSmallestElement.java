package FunctionalProgrammingExercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class P07FindTheSmallestElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> inputNums = Arrays.stream(scanner.nextLine()
                .split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        Function<List<Integer>, Integer> findIndexOfSmallestNum = arr -> {

            int smallest =  arr.stream().min(Integer::compare).get();
            return inputNums.lastIndexOf(smallest);
        };

        System.out.println(findIndexOfSmallestNum.apply(inputNums));

    }
}
