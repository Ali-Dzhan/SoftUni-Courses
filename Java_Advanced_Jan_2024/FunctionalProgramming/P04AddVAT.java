package FunctionalProgramming;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Function;

public class P04AddVAT {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Prices with VAT:");

        Function<String, Double> parsePriceWithVAT = s -> Double.parseDouble(s) * 1.2;

        Arrays.stream(scanner.nextLine().split(", "))
                .map(parsePriceWithVAT)
                .forEach(s -> System.out.printf("%.2f%n", s));
    }
}
