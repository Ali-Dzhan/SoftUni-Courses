package FirstStepsInCoding.Lab.ExamExercises;

import java.util.Scanner;

public class BirthCake {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        double rent = Double.parseDouble(scanner.nextLine());

        double cake = 0.20 * rent;
        double drinks = cake - (cake * 0.45);
        double animator = rent / 3;

        double sum = cake + drinks + rent + animator;
        System.out.println(sum);

        }
    }

