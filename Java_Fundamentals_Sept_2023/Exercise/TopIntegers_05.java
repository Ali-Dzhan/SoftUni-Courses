package Arrays.Exercise;

import java.util.Arrays;
import java.util.Scanner;

public class TopIntegers_05 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int[] numbers = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        //!!! последния елемент винаги е топ число -> отпечатваме
        for (int index = 0; index < numbers.length - 1; index++) {
            //всички числа без последното и ги проверяваме дали са топ числа
            int currentNumber = numbers[index]; //число на текущия индекс

            boolean isBigger = true;
            //true -> текущото число е по-голямо от всички в дясно
            //false -> текущото число не е по-голямо

            for (int i = index +1 ; i <= numbers.length -1 ; i++) {

                int nextNumber = numbers[i];

                if(currentNumber <= nextNumber){
                    isBigger = false;
                    break;
                }
                
            }
            if(isBigger){

                System.out.print(currentNumber + " ");
            }


        }
        System.out.print(numbers[numbers.length - 1]);

    }
}
