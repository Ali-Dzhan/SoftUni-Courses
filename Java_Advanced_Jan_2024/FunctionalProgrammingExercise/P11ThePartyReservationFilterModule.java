package FunctionalProgrammingExercise;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class P11ThePartyReservationFilterModule {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> guests = Arrays.stream(scanner.nextLine().split(" ")).collect(Collectors.toList());

        Set<String> filters = new HashSet<>();

        String command = scanner.nextLine();

        while (!command.equals("Print")) {
            String[] commandsPart = command.split(";");
            String addOrRemove = commandsPart[0];
            String type = commandsPart[1];
            String parameter = commandsPart[2];
            if (addOrRemove.equals("Add filter")) {
                filters.add(type + ";" + parameter);
            } else {
                filters.remove(type + ";" + parameter);
            }
            command = scanner.nextLine();
        }

        filters.forEach(filter -> {
            Predicate<String> filterToApply = getPredicate(filter);
            guests.removeIf(filterToApply);
        });

        guests.forEach(name -> System.out.print(name +" "));
    }

    private static Predicate<String> getPredicate(String filter) {
        String filterType = filter.split(";")[0];
        String parameter = filter.split(";")[1];
        if (filterType.equals("Starts with")) {
            return s -> s.startsWith(parameter);
        } else if (filterType.equals("Ends with")) {
            return s -> s.endsWith(parameter);
        } else if (filterType.equals("Length")) {
            return s -> s.length() == Integer.parseInt(parameter);
        } else {
            return s -> s.contains(parameter);
        }
    }
}
