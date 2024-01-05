package List.Lab;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P02GaussTrick {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        List<Integer> numbersList = Arrays.stream(scanner.nextLine().split(" "))
                .map(e -> Integer.parseInt(e))
                .collect(Collectors.toList());
        
        List<Integer> result = new ArrayList<>();

        if(numbersList.size() % 2 != 0) {

            int midIndx = numbersList.size() / 2;
            numbersList.add(midIndx, 0);
        }
            for (int i = 0; i < numbersList.size() / 2; i++) {
                int leftElement = numbersList.get(i);
                int rightElement = numbersList.get(numbersList.size() - i - 1);
                result.add(leftElement + rightElement);
            }

            System.out.println(String.join(" ", result.stream().map(e -> String.valueOf(e)).toArray(String[] :: new)));

        }
    }

