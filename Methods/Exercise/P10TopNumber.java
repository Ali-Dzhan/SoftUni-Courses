package Methods.Exercise;

import java.util.Scanner;

public class P10TopNumber {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i <= n; i++) {
            if (isTopNUmber(i)) {
                System.out.println(i);
            }
        }
    }

    public static boolean isTopNUmber(int n) {
        boolean isDivideToEight = false;
        boolean isOddDigit = false;
        int sumOfN = 0;

        while (n > 0) {
            int currentDigit = n % 10;
            sumOfN += currentDigit;
            if (currentDigit % 2 != 0) {
                isOddDigit = true;
            }
            n = n / 10;
        }
        if (sumOfN % 8 == 0) {
            isDivideToEight = true;
        }
        if (isDivideToEight && isOddDigit) {
            return true;
        } else {
            return false;
        }
    }
}
