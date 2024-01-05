package FirstStepsInCoding.Lab.exercises2;

import java.util.Scanner;

public class LunchBreak {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String name = scanner.nextLine();
        int episodeDuration = Integer.parseInt(scanner.nextLine());
        int lunchBreakDuration = Integer.parseInt(scanner.nextLine());

        double timeForEat = lunchBreakDuration / 8.0;
        double timeForRest = lunchBreakDuration / 4.0;

        double timeForWatch = lunchBreakDuration - timeForEat - timeForRest;

        if(timeForWatch >= episodeDuration){
            System.out.printf("You have enough time to watch %s and left with %.0f minutes free time.", name, Math.ceil(timeForWatch - episodeDuration));
        } else {
            System.out.printf("You don't have enough time to watch %s, you need %.0f more minutes.", name, Math.ceil(episodeDuration - timeForWatch));
    }
}}
