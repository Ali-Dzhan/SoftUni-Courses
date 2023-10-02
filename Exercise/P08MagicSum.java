package Arrays.Exercise;

import java.util.Arrays;
import java.util.Scanner;

public class P08MagicSum {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int[] numbers = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int magicSum = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i <= numbers.length - 1; i++) {

            int currentNumber = numbers[i];
            for (int j = i; j <= numbers.length - 1; j++) {
                int nextNumber =numbers[j];
                if(i==j){
                    continue;
                }
                if(currentNumber+nextNumber==magicSum){
                    System.out.println(currentNumber+" "+nextNumber);
                }

            }
            
        }
    }
}
