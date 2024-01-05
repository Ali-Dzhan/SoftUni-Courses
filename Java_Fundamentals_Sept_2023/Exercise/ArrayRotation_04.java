package Arrays.Exercise;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayRotation_04 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int[] numbers = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int rotations = Integer.parseInt(scanner.nextLine()); //брой ротации

        for (int rotation = 1; rotation <= rotations; rotation++) {
            //ротация на масива
            //1. взимаме първия елемент
            int firstElement = numbers[0]; //51
            //2. преместваме елементите (копиране) елементите наляво
            //!!!без промяна на последната позиция
            //[51, 47, 32, 61, 21] -> //[47, 32, 61, 21, 21]
            for (int index = 0; index < numbers.length - 1; index++) {
                numbers[index] = numbers[index + 1];
            }
            //3. поставяме първия елемент на последно място
            //[47, 32, 61, 21, 51]
            numbers[numbers.length - 1] = firstElement;
        }

        //приключили с ротациите -> принтираме елементите на масива
        for (int number : numbers) {
            System.out.print(number + " ");
        }
    }
}
