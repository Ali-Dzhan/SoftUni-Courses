package Methods.lab;

import java.util.Scanner;

public class P03PrintingTriangle {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= size; i++) {
            printRow(i);

        }
        for (int i = size-1; i >=1 ; i--) {
            printRow(i);
        }
    }
    public static void printRow(int elementsRow){
        for (int i = 1; i <= elementsRow ; i++) {
            System.out.printf("%d ",i);

        }
        System.out.println();
    }
}
