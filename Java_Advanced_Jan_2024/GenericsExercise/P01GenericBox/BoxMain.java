package GenericsExercise.P01GenericBox;

import GenericsExercise.P01GenericBox.Box;

import java.util.Scanner;

public class BoxMain {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine();
            Box<String> box = new Box<String>(input);
            System.out.println(box);
        }
    }
}
