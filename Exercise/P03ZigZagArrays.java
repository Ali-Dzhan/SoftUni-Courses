package Arrays.Exercise;

import java.util.Scanner;

public class P03ZigZagArrays {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int rows = Integer.parseInt(scanner.nextLine());

        int [] firstArr = new int[rows];
        int [] secondArr = new int[rows];

        for (int row = 1; row <= rows; row++) {
            String input = scanner.nextLine();
            String [] numbers = input.split(" ");

            int number1 = Integer.parseInt(numbers[0]);
            int number2 = Integer.parseInt(numbers[1]);

            if (row % 2 != 0){

                firstArr[row-1]=number1;
                secondArr[row-1]=number2;

            }else{
                secondArr[row-1]= number1;
                firstArr[row -1]= number2;

            }

        }
        for (int number:firstArr
             )
            System.out.print(number+" ");{
            
        }
        System.out.println();
        for (int number:secondArr
        )
            System.out.print(number+" ");{

        }


    }
}
