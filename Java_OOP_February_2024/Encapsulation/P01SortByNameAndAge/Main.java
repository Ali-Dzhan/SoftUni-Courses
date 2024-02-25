package Encapsulation.P01SortByNameAndAge;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());

        List<Person1> people = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] input = reader.readLine().split(" ");
            people.add(new Person1(input[0], input[1], Integer.parseInt(input[2]), Double.parseDouble(input[3])));
        }

        people.sort((firstPerson, secondPerson) -> {
            int sComp = firstPerson.getFirstName().compareTo(secondPerson.getFirstName());

            if (sComp != 0) {
                return sComp;
            } else {
                return Integer.compare(firstPerson.getAge(), secondPerson.getAge());
            }
        });

        for (Person1 person : people) {
            System.out.println(person.toString());
        }
    }
}
