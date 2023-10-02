package Arrays.Exercise;

import java.util.Scanner;

public class P02CommonElements {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] firstArr = scanner.nextLine().split(" ");
        String[] SecondArr = scanner.nextLine().split(" ");

        for (String currentSecondString: SecondArr

             ) {
            for (String currentFirstString: firstArr

                 ) {
                if(currentSecondString.equals(currentFirstString)){
                    System.out.print(currentSecondString + " ");
                }
            }

        }

    }
}
