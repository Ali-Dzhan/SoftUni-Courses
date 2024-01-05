package Methods.Exercise;

import java.util.Scanner;

public class P01SmallestOfThreeNumbers {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int number1 = Integer.parseInt(scanner.nextLine());
        int number2 = Integer.parseInt(scanner.nextLine());
        int number3 = Integer.parseInt(scanner.nextLine());

        System.out.println(smallestNumber(number1, number2, number3));

    }
     public static int smallestNumber(int number1, int number2, int number3){
        int min = Integer.MAX_VALUE;

        if(number1<=number2 && number1<=number3){
            min = number1;
        } else if (number2<=number1 && number2<=number3) {
            min =number2;

        } else if (number3<=number2 && number3<=number1) {
            min = number3;
        }
        return min;
     }
}
