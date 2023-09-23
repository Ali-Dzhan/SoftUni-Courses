package DataTypesAndVariables.Exercise;

import java.util.Scanner;

public class P07WaterOverflow {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        int remainingVolume = 255;
        for (int i = 0; i <n ; i++) {
            int quantity = Integer.parseInt(scanner.nextLine());

            if(quantity<=remainingVolume){
                remainingVolume -=quantity;
            }else{
                System.out.println("Insufficient capacity!");
            }
        }
        System.out.println(255-remainingVolume);

        }
    }

