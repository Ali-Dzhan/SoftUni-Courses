package InterfacesAndAbstraction.P05BorderControl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        List<Identifiable> identifiabels = new ArrayList<>();

        String input = scanner.nextLine();

        while (!input.equals("End")) {

            String[] tokens = input.split("\\s+");

            Identifiable identifiable = tokens.length == 2
                    ? new Robot(tokens[1], tokens[0])
                    : new Citizen(tokens[2], Integer.parseInt(tokens[1]), tokens[1]);

            identifiabels.add(identifiable);

            input = scanner.nextLine();
        }

        String fakeIdPostfix = scanner.nextLine();

        identifiabels
                .stream()
                .map(Identifiable::getId)
                .filter(i -> i.endsWith(fakeIdPostfix))
                .forEach(System.out::println);

    }
}
