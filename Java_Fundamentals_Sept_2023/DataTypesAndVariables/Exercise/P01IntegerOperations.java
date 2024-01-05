package DataTypesAndVariables.Exercise;

import java.util.Scanner;

public class P01IntegerOperations {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Integer number1 = Integer.parseInt(scanner.nextLine());
        Integer number2 = Integer.parseInt(scanner.nextLine());
        Integer number3 = Integer.parseInt(scanner.nextLine());
        Integer number4 = Integer.parseInt(scanner.nextLine());

        System.out.println(((number1+number2)/number3)*number4);
    }
}
