package DataTypesAndVariables.Exercise;

import java.util.Scanner;

public class P09SpiceMustFlow {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int startYield = Integer.parseInt(scanner.nextLine());
        int days = 0;
        int total = 0;
        boolean flag = false;

        while(startYield>=100){

            days ++;
            int spicePerDay = startYield -26;
            total += spicePerDay;
            flag = true;

            startYield -= 10;
        }
        if(flag){
            total -= 26;
        }
        System.out.println(days);
        System.out.println(total);
    }
}
