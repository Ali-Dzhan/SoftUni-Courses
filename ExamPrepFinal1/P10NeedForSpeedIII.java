package ExamPrepFinal1;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class P10NeedForSpeedIII {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfCars = Integer.parseInt(scanner.nextLine());

        Map<String, Integer> carMileage = new LinkedHashMap<>();
        Map<String, Integer> carFuel = new LinkedHashMap<>();

        for (int i = 0; i < numberOfCars; i++) {
            String[] inputCars = scanner.nextLine().split("\\|");
            String car = inputCars[0];
            int mileage = Integer.parseInt(inputCars[1]);
            int fuel = Integer.parseInt(inputCars[2]);

            carMileage.put(car, mileage);
            carFuel.put(car, fuel);
        }
        String input = scanner.nextLine();
        while(!input.equals("Stop")){
            String car = "";
            int distance = 0;
            int fuel = 0;
            int currentFuel = 0;
            String commandLine[] = input.split(" : ");
            String command = commandLine[0];
            switch (command){
                case "Drive":
                    car = commandLine[1];
                    distance = Integer.parseInt(commandLine[2]);
                    fuel = Integer.parseInt(commandLine[3]);

                    currentFuel = carFuel.get(car);

                    if(currentFuel < fuel){
                        System.out.println("Not enough fuel to make that ride");
                    } else {
                        int currentDistance = carMileage.get(car);

                        carMileage.put(car, currentDistance + distance);
                        carFuel.put(car, currentFuel - fuel);

                        System.out.printf("%s driven for %d kilometers. %d liters of fuel consumed.%n", car, distance, fuel);

                        if (carMileage.get(car) > 100_000){
                            System.out.printf("Time to sell the %s!\n", car);
                            carMileage.remove(car);
                            carFuel.remove(car);
                        }
                    }

                    break;
                case "Refuel":
                    car = commandLine[1];
                    fuel = Integer.parseInt(commandLine[2]);
                    currentFuel = carFuel.get(car);
                    int refuel = currentFuel + fuel;

                    if(refuel > 75){
                        refuel = 75;
                        fuel = 75 - currentFuel;
                    }
                    carFuel.put(car,refuel);
                    System.out.printf("%s refueled with %d liters\n", car, fuel);
                    break;
                case "Revert":
                    car = commandLine[1];
                    distance = Integer.parseInt(commandLine[2]);

                    int currentMileage = carMileage.get(car);
                    carMileage.put(car, currentMileage - distance);
                    System.out.printf("%s mileage decreased by %d kilometers%n",car,distance);

                    if(carMileage.get(car) < 10_000){
                        carMileage.put(car, 10_000);
                    }
                    break;
            }
            input = scanner.nextLine();
        }

        carMileage.forEach((car, mileage) -> {
            int fuel = carFuel.get(car);
            System.out.printf("%s -> Mileage: %d kms, Fuel in the tank: %d lt.%n", car, mileage, fuel);
        });
    }
}
