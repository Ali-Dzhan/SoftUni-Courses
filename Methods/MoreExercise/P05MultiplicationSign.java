package Methods.MoreExercise;

import java.util.Scanner;

public class P05MultiplicationSign {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int firstNum = Integer.parseInt(scanner.next());
        int secondNum = Integer.parseInt(scanner.next());
        int thirdNum =Integer.parseInt(scanner.next());

        int br = PositiveNegative(firstNum, secondNum, thirdNum);

        if(br == -1){
            System.out.println("zero");
        } else if (br % 2 == 0) {
            System.out.println("negative");
        } else {
            System.out.println("positive ");
        }
    }

    public static int PositiveNegative(int num1, int num2, int num3){
        int br = 0;
        if(num1 == 0 || num2 == 0 || num3 ==0){
            br = -1;
            return br;
        }
        if(num1 > 0) {
            br++;
        }
        if(num2 > 0) {
            br++;
        }
        if(num3 > 0) {
            br++;
        }
        return br;

    }
}
