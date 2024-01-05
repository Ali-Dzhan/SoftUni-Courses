package Methods.MoreExercise;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Scanner;

public class P04TribonacciSequence {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        int[] result = TribonacciNumbers(n);

        System.out.println(Arrays.toString(result).replaceAll( "[\\[\\],]", ""));



    }
    private static int[] TribonacciNumbers(int n){
         int[] result = new int[n];
        switch (n){
            case 1:
                result[0] = 1;
                break;
            case 2:
                result[0] = 1;
                result[1] = 1;
                break;
            case 3:
                result[0] = 1;
                result[1] = 1;
                result[2] = 2;
                break;
            default:
                result[0] = 1;
                result[1] = 1;
                result[2] = 2;
                for (int i = 3; i < n; i++)
                {
                    int currNum = result[i - 3] + result[i - 2] + result[i - 1];
                    result[i] = currNum;
                }
                break;
        }

        return result;
    }
}

