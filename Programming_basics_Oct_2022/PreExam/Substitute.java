package FirstStepsInCoding.Lab.PreExam;

import java.util.Scanner;

public class Substitute {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int K = Integer.parseInt(scanner.nextLine());
        int L = Integer.parseInt(scanner.nextLine());
        int M = Integer.parseInt(scanner.nextLine());
        int N = Integer.parseInt(scanner.nextLine());
        int counter = 0;
        boolean hasEnded = false;

        for (int first = K; first <= 8; first++) {
            for (int second = 9; second >= L; second--) {
                for (int third = M; third <= 8; third++) {
                    for (int fourth = 9; fourth >= N; fourth--) {

                        boolean isValid = first % 2 == 0 && second % 2 != 0 && third % 2 == 0 && fourth % 2 != 0;

                        int firstNum = first * 10 + second;
                        int secondNum = third * 10 + fourth;

                        if (isValid && firstNum == secondNum) {
                            System.out.println("Cannot change the same player.");
                        } else if (isValid && firstNum != secondNum) {
                            System.out.printf("%d%d - %d%d%n",first,second,third,fourth);
                            counter++;
                        }

                        if (counter >= 6) {
                            hasEnded = true;
                        }

                        if (hasEnded){
                            break;
                        }
                    }
                    if (hasEnded){
                        break;
                    }
                }
                if (hasEnded){
                    break;
                }
            }
            if (hasEnded){
                break;
            }
        }



    }
}
