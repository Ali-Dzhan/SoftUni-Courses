package FirstStepsInCoding.Lab.PreExam;

import java.util.Scanner;

public class CatDiet {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int PercentFats = Integer.parseInt(scanner.nextLine());
        int PercentProtein = Integer.parseInt(scanner.nextLine());
        int PercentCarbs = Integer.parseInt(scanner.nextLine());
        int SumCalories = Integer.parseInt(scanner.nextLine());
        double PercentWater = Double.parseDouble(scanner.nextLine());

        double SumFats = ((PercentFats * 0.01) * SumCalories) / 9;
        double SumProtein = ((PercentProtein * 0.01) * SumCalories) / 4;
        double SumCarbs = ((PercentCarbs * 0.01) * SumCalories) / 4;

        double SumFood = SumCarbs + SumProtein + SumFats;

        double CaloriesPerFood = SumCalories / SumFood;

        double PercentWaterGrams = 1 - (PercentWater * 0.01);

        double calories = CaloriesPerFood * PercentWaterGrams;

        System.out.printf("%.4f", calories);


    }
}
