package FirstStepsInCoding.Lab.exercise5;

import java.util.Scanner;

public class Coins {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double change = Double.parseDouble(scanner.nextLine());
        double totalCoins = Math.floor(change * 100);
        int countCoins = 0;

        while (totalCoins > 0) {

            if (totalCoins >= 200) {
                countCoins++;
                totalCoins -= 200;

            } else if (totalCoins >= 100) {
                countCoins++;
                totalCoins -= 100;
            } else if (totalCoins >= 50) {
                countCoins++;
                totalCoins -= 50;

            } else if (totalCoins >= 20) {
                countCoins++;
                totalCoins -= 20;
            } else if (totalCoins >= 10) {
                countCoins++;
                totalCoins -= 10;
            } else if (totalCoins >= 5) {
                countCoins++;
                totalCoins -= 5;
            } else if (totalCoins >= 2) {
                countCoins++;
                totalCoins -= 2;
            } else if (totalCoins >= 1) {
                countCoins++;
                totalCoins -= 1;
            }
        }
        System.out.println(countCoins);
    }
}