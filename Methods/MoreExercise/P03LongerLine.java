package Methods.MoreExercise;

import java.util.Scanner;

public class P03LongerLine {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int x1 = Integer.parseInt(scanner.nextLine());
        int y1 = Integer.parseInt(scanner.nextLine());
        int x2 = Integer.parseInt(scanner.nextLine());
        int y2 = Integer.parseInt(scanner.nextLine());
        int x3 = Integer.parseInt(scanner.nextLine());
        int y3 = Integer.parseInt(scanner.nextLine());
        int x4 = Integer.parseInt(scanner.nextLine());
        int y4 = Integer.parseInt(scanner.nextLine());

        double line1 = Math.sqrt((x1- x2)*(x1- x2) + (y1- y2)*(y1 - y2));
        double line2 = Math.sqrt((x3 - x4) * (x3 - x4) + (y3 - y4)*(y3 - y4));

        if (line1 >= line2)
        {
            boolean first = true;
            if (Math.sqrt(x1*x1 + y1*y1) > Math.sqrt(x2 * x2 + y2 * y2)) {
                first = false;
            }
            if (first) {
                System.out.println("(" + x1 + "," + " " + y1 + ")" + "(" + x2 + "," + " " + y2 + ")" );
            } else {
                System.out.println("(" + x2 + "," + " " + y2 + ")" + "(" + x1 + "," + " " + y1 + ")" );
                }
        }
        else {

            boolean first = true;
            if (Math.sqrt(x3 * x3 + y3 * y3) > Math.sqrt(x4 * x4 + y4 * y4)) {
                first = false;
            }

            if (first) {
                System.out.println("(" + x3 + "," + " " + y3 + ")" + "(" + x4 + "," + " " + y4 + ")" );
            } else {
                System.out.println("(" + x4 + "," + " " + y4 + ")" + "(" + x3 + "," + " " + y3 + ")" );
            }
        }
    }


}
