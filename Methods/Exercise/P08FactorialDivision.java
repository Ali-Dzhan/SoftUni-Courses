package Methods.Exercise;

import java.util.Scanner;

public class P08FactorialDivision {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int first = Integer.parseInt(scanner.nextLine());
        int second = Integer.parseInt(scanner.nextLine());

        long factFirstNumber = calcFactorial(first);

        long factSecondNumber = calcFactorial(second);

        double result = factFirstNumber * 1.0 / factSecondNumber;
        System.out.printf("%.2f",result);



    }

    public static long calcFactorial(int number){
        long fact = 1;
        for (int i = 1; i <=number ; i++) {
            fact = fact * i;

            
        }
        return fact;
    }
}
