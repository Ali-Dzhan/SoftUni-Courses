package Methods.MoreExercise;

import java.util.Scanner;

public class P01DataTypes {
    public static void main(String[] args) {

       Scanner scanner = new Scanner(System.in);

       String input = scanner.nextLine();
       String n = scanner.nextLine();
       int numberInt = 0;
       double numberReal = 0.0;
       String inputString = "";

        switch (input){
            case "int":
                numberInt = Integer.parseInt(n);
                in(numberInt);
                break;

            case "real":
                numberReal = Double.parseDouble(n);
                real(numberReal);
                break;

            case "string":
                inputString = n;
                string(inputString);
                break;
        }
    }

    public static void in(int Integer) {
        int multiply= 2;
        int result = Integer * multiply;
        System.out.println(result);
    }
    public static void real(double Double) {
        double multiply= 1.5;
        double result = Double * multiply;
        System.out.printf("%.2f",result);
    }

    public static void string(String inputString){
        String surroundedString = String.format("$%s$",inputString);
        System.out.println(surroundedString);
    }
}
