package FirstStepsInCoding.Lab.exercise4;

import java.util.Scanner;

public class TrekkingMania {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int numberGroups = Integer.parseInt(scanner.nextLine());

        double allOfThePeople = 0;


        double pMusala = 0;
        double pMonBlanc = 0;
        double pKilimanjaro = 0;
        double pK2 = 0;
        double pEverest = 0;




        for (int i = 1; i <= numberGroups ; i++) {
            int people = Integer.parseInt(scanner.nextLine());
            allOfThePeople += people;


            if (people < 6){

                pMusala+=people;


            } else if (people<=12) {

                pMonBlanc+=people;
                
            } else if (people<=25) {

                pKilimanjaro+=people;
                
            } else if (people<=40) {

                pK2+=people;

            }else{

                pEverest+=people;
            }

        }
        double p1Percent = pMusala/allOfThePeople*100;
        double p2Percent = pMonBlanc/allOfThePeople*100;
        double p3Percent = pKilimanjaro/allOfThePeople*100;
        double p4Percent = pK2/allOfThePeople*100;
        double p5Percent = pEverest/allOfThePeople*100;

        System.out.printf("%.2f%%%n", p1Percent);
        System.out.printf("%.2f%%%n", p2Percent);
        System.out.printf("%.2f%%%n", p3Percent);
        System.out.printf("%.2f%%%n", p4Percent);
        System.out.printf("%.2f%%%n", p5Percent);



    }
}
