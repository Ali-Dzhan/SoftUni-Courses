package Methods.lab;

import java.text.DecimalFormat;
import java.util.Scanner;

public class P08MathPower {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        double number = Double.parseDouble(scanner.nextLine());
        double power = Double.parseDouble(scanner.nextLine());

        double result = pow(number,power);

        DecimalFormat df = new DecimalFormat("0.#####");
        System.out.println(df.format(result));


    }
    public static double pow(double number, double power ){
        return Math.pow(number,power);
    }

}
