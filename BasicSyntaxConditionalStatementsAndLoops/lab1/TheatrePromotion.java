package BasicSyntaxConditionalStatementsAndLoops.lab1;

import java.util.Scanner;

public class TheatrePromotion {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // Read the type of day (Weekday, Weekend, or Holiday)
        String day = scanner.nextLine().toLowerCase();

        // Read the age of the person
        int age = scanner.nextInt();

        // Calculate the ticket price based on the provided table
        int price = 0;

        if (day.equals( "weekday")){

            if (age <= 18 && age >= 0 || age <= 122 && age > 64)
            {
                price = 12;
            }
            else if (age <= 64 && age > 18)
            {
                price = 18;
            }

        }
        else if (day.equals("weekend"))
        {
            if (age <= 18 && age >= 0 || age <= 122 && age > 64)
            {
                price = 15;
            }
            else if (age <= 64 && age > 18)
            {
                price = 20;
            }
        }
        else if (day.equals("holiday"))
        {
            if (age <= 18 && age >= 0)
            {
                price = 5;
            }
            else if (age <= 122 && age > 64)
            {
                price = 10;
            }
            else if (age <= 64 && age > 18)
            {
                price = 12;
            }
        }

        if (price != 0)
            System.out.println(price + "$");
        else
            System.out.println("Error!");
        }
    }


