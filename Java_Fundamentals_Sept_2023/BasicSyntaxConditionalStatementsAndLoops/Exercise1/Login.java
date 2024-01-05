package BasicSyntaxConditionalStatementsAndLoops.Exercise1;

import java.util.Scanner;

public class Login {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String username = sc.nextLine();

        String password= "";

        for (int position = username.length()-1; position >=0 ; position--) {
            char currentSymbol = username.charAt(position);
            password += currentSymbol;
        }

        int counterWrongPass = 0;

        String enteredPassword = sc.nextLine();

        while(!enteredPassword.equals(password)){
            counterWrongPass ++;
            if(counterWrongPass >= 4){
                System.out.printf("User %s blocked!",username);
                return;
            }

            System.out.println("Incorrect password. Try again.");
            enteredPassword = sc.nextLine();
        }

        System.out.printf("User %s logged in.", username);
    }
}
