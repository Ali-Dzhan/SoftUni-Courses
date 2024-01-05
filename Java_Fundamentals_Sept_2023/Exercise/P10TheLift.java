package Arrays.Exercise;

import java.util.Arrays;
import java.util.Scanner;

public class P10TheLift {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int waitingPeople = Integer.parseInt(scanner.nextLine());

        int[] arrayLift = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();


        for (int i = 0; i < arrayLift.length; i++) {
            int element = arrayLift[i];

            for (int j = 0; j < 4 - element; j++) {
                if (waitingPeople <= 0) {
                    break;
                }
                arrayLift[i]++;
                waitingPeople--;

            }

        }
        if (isEmptySpots(arrayLift)) {
            System.out.println("The lift has empty spots!");

        } else if (waitingPeople > 0) {
            System.out.printf("There isn't enough space! %d people in a queue!%n", waitingPeople);
        }

        System.out.println(Arrays.toString(arrayLift).replaceAll("[\\[\\],]", ""));


    }

    private static boolean isEmptySpots(int[] arrayLift) {
        boolean isEmptySpots = false;
        for (int currentElement : arrayLift) {
            if (currentElement < 4) {
                isEmptySpots = true;
                break;
            }

        }
              return isEmptySpots;
    }
}


