package FirstStepsInCoding.Lab.PreExam;

import java.util.Scanner;

public class Exam {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int Students = Integer.parseInt(scanner.nextLine());

        double group1 = 0;
        double group2 = 0;
        double group3 = 0;
        double group4 = 0;
        double sum = 0;


        for (int i = 1; i <= Students; i++) {
            double grade = Double.parseDouble(scanner.nextLine());



            if (grade >= 5.00) {
                group1++;

            } else if (grade >= 4 && grade <= 4.99) {
                group2++;

            } else if (grade >= 3 && grade <= 3.99) {
                group3++;

            } else {
                group4++;

            }
            sum += grade;


        }

        double PercentGroup1 = group1 / Students *100;
        double PercentGroup2 = group2 / Students *100;
        double PercentGroup3 = group3 / Students *100;
        double PercentGroup4 = group4 / Students *100;

        double average = sum/Students;

        System.out.printf("Top students: %.2f%%%n", PercentGroup1);
        System.out.printf("Between 4.00 and 4.99: %.2f%%%n", PercentGroup2);
        System.out.printf("Between 3.00 and 3.99: %.2f%%%n", PercentGroup3);
        System.out.printf("Fail: %.2f%%%n", PercentGroup4);
        System.out.printf("Average: %.2f", average);


    }
}
