package FirstStepsInCoding.Lab.exercise4;

import java.util.Scanner;

public class NumbersEndingIn_7 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        for (int i = 1; i <= 1000 ; i++) {
            if(i%10==7){
                System.out.println(i);
            }

        }
    }
}
