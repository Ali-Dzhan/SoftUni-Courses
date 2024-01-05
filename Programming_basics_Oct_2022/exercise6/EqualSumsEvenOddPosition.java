package FirstStepsInCoding.Lab.exercise6;

import java.util.Scanner;

public class EqualSumsEvenOddPosition {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int a = Integer.parseInt(in.nextLine());
        int b = Integer.parseInt(in.nextLine());
        for (int i = a; i <= b; i++) {
            int copy = i;
            int counter = 1;
            int sumEven = 0, sumOdd = 0;
            while(copy > 0){
                if(counter%2==0){
                    sumEven+=copy%10;
                }else{
                    sumOdd+=copy%10;
                }
                copy/=10;
                counter++;
            }
            if(sumEven == sumOdd){
                System.out.printf("%d ",i);
            }
        }
    }
}
