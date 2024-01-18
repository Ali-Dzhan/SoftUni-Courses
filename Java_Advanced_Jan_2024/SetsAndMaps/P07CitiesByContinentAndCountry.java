package SetsAndMaps;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Scanner;

public class P07CitiesByContinentAndCountry {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        LinkedHashMap<String, LinkedHashMap<String, List<String>>>
                countriesByContinent = new LinkedHashMap<>();

        while (n-- > 0) {
            String[] inputs = scanner.nextLine().split("\\s+");

            String continent = inputs[0];
            String country = inputs[1];
            String city = inputs[2];

            countriesByContinent.putIfAbsent(continent, new LinkedHashMap<>());
            LinkedHashMap<String, List<String>> citiesByCountry =
                    countriesByContinent.get(continent);

            citiesByCountry.putIfAbsent(country, new ArrayList<>());
            List<String> cities = citiesByCountry.get(country);
            cities.add(city);
        }

        countriesByContinent.forEach((continent, counties) -> {
            System.out.println(continent + ":");

            counties.forEach((country, cities) -> {
                String citiesAsString = String.join(", ", cities);
                System.out.println("  " + country + " -> " + citiesAsString);
            });
        });
    }
}
