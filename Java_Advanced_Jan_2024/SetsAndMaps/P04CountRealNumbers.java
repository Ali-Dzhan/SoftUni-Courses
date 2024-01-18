package SetsAndMaps;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Scanner;

public class P04CountRealNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double[] numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToDouble(Double::parseDouble)
                .toArray();

        LinkedHashMap<Double, Integer> mapOfNumbers = new LinkedHashMap<>();

        for (double num: numbers) {
            if (!mapOfNumbers.containsKey(num)) {
                mapOfNumbers.put(num, 1);
            } else {
                mapOfNumbers.put(num, mapOfNumbers.get(num) + 1);
            }
        }

        for (double k: mapOfNumbers.keySet()) {

            System.out.printf("%.1f -> %d\n", k, mapOfNumbers.get(k));

        }

    }
}
