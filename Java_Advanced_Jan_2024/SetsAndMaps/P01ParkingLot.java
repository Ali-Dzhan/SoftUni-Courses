package SetsAndMaps;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class P01ParkingLot {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Set<String> parking = new LinkedHashSet<>();
        String input = scanner.nextLine();

        while(!"END".equals(input)){
            String[] tokens = input.split(",\\s+");
            if(tokens[0].equals("IN")){
                parking.add(tokens[1]);
            } else if(tokens[0].equals("OUT")){
                parking.remove(tokens[1]);
            }
            input = scanner.nextLine();
        }

        if(parking.isEmpty()){
            System.out.println("Parking Lot is Empty");
        } else {
            for (String car:parking) {
                System.out.println(car);
            }
        }
    }
}
