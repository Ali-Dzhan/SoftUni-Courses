package SetsAndMapsExercise;

import java.util.*;

public class P12SrubskoUnleashed {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Map<String, Long>> performerInfo = new LinkedHashMap<>();
        String performer = "";
        String venue = "";
        long ticketPrice = 0;
        long ticketCount = 0;
        long totalCurrentProfit = 0;

        while (true) {
            String input = scanner.nextLine();

            if (input.startsWith("End")) {
                break;
            }

            String[] checkInvalid = input.split("\\s+");

            boolean startsWithAt = false;

            for (String element : checkInvalid) {
                if (element.startsWith("@")) {
                    startsWithAt = true;
                }
            }

            if (!startsWithAt) {
                continue;
            }

            long digit;

            boolean isDigit = checkInvalid[checkInvalid.length - 1].matches("\\d+");
            boolean isDigit1 = checkInvalid[checkInvalid.length - 2].matches("\\d+");

            if (!isDigit || !isDigit1 || checkInvalid.length < 4) {
                continue;
            }

            String[] arr = input.split("@");

            performer = arr[0];

            String[] venuePriceTickets = arr[1].split("\\s+");

            ticketCount = Long.parseLong(venuePriceTickets[venuePriceTickets.length - 1]);
            ticketPrice = Long.parseLong(venuePriceTickets[venuePriceTickets.length - 2]);
            totalCurrentProfit = ticketPrice * ticketCount;

            String[] venueArr = Arrays.copyOfRange(venuePriceTickets, 0, venuePriceTickets.length - 2);
            venue = String.join(" ", venueArr);

            performerInfo.computeIfAbsent(venue, k -> new LinkedHashMap<>());
            performerInfo.get(venue).merge(performer, totalCurrentProfit, Long::sum);
        }

        performerInfo.forEach((k, v) -> {
            System.out.println(k);

            v.entrySet().stream()
                    .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                    .forEach(entry -> System.out.printf("#  %s-> %d%n", entry.getKey(), entry.getValue()));
        });
    }
}
