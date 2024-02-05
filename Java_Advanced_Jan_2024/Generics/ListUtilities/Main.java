package Generics.ListUtilities;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        int min = ListUtilities.getMin(numbers);

        List<String> strings = List.of("a", "b", "c", "d", "e");
        String max = ListUtilities.getMax(strings);

        System.out.printf("Min: %d%nMax: %s", min, max);
    }
}
