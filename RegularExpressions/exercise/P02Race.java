package RegularExpressions.exercise;

import java.util.*;
import java.util.Map.Entry;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import static java.util.Map.Entry.*;

public class P02Race {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        List<String> racerList = Arrays.stream(scanner.nextLine().split(", ")).toList();
        Map<String, Integer> racersMap = new LinkedHashMap<>();
        racerList.forEach(element -> racersMap.put(element, 0));


        String input = scanner.nextLine();

        Pattern letter = Pattern.compile("[A-Za-z]+");
        Pattern digit = Pattern.compile("[0-9]");

        while (!input.equals("end of race")) {
            int distance = 0;

            StringBuilder nameBuilder = new StringBuilder();

            Matcher matchLetter = letter.matcher(input);
            Matcher matchDigit = digit.matcher(input);
            while (matchLetter.find()) {
                nameBuilder.append(matchLetter.group());
            }
            while (matchDigit.find()) {
                distance += Integer.parseInt(matchDigit.group());
            }

            String name = nameBuilder.toString();
            if (racersMap.containsKey(name)) {
                int currentDistance = racersMap.get(name);
                racersMap.put(name, currentDistance + distance);
            }


            input = scanner.nextLine();
        }
        // взима първите три записа
        //на евсеки запис от мапа взимаме ключа и го записваме в лист.
        List<Entry<String, Integer>> toSort = new ArrayList<>(racersMap.entrySet());
        toSort.sort(comparingByValue(Comparator.reverseOrder()));
        List<String> nameOfFirstTree = new ArrayList<>();
        long limit = 3;
        for (Entry<String, Integer> stringIntegerEntry : toSort) {
            if (limit-- == 0) break;
            String key = stringIntegerEntry.getKey();
            nameOfFirstTree.add(key);
        }

        System.out.println("1st place: "+nameOfFirstTree.get(0));
        System.out.println("2nd place: "+nameOfFirstTree.get(1));
        System.out.println("3rd place: "+nameOfFirstTree.get(2));

    }
}
