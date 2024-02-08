package GenericsExercise.P01GenericBox;

import GenericsExercise.P01GenericBox.Box;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class P03SwapStrings {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Box<String>> boxList = new ArrayList<>();
        int n = Integer.parseInt(scanner.nextLine());

        while (n-- > 0) {
            Box<String> box = new Box<>(scanner.nextLine());
            boxList.add(box);
        }
        int[] tokens = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        swap(boxList, tokens[0], tokens[1]);

        boxList.forEach(System.out::println);
    }

    static <T> void swap(List<T> boxList, int firstIndex, int secondIndex) {
        T firstElement = boxList.get(firstIndex);
        T secondElement = boxList.get(secondIndex);
        boxList.set(firstIndex, secondElement);
        boxList.set(secondIndex, firstElement);
    }
}
