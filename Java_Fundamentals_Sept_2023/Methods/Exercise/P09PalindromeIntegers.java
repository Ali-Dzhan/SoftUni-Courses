package Methods.Exercise;

import java.util.Scanner;

public class P09PalindromeIntegers {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String number = scanner.nextLine();

        while(!number.equals("END")){
            if(isPalindrome(number)){
                System.out.println("true");
            } else {
                System.out.println("false");
            }
            number = scanner.nextLine();
        }
    }

    public static boolean isPalindrome(String number){
        boolean palindrome = false;
        if(number.length() == 1){
           palindrome = true;
           
        } else {
            for (int i = 0; i < number.length() / 2; i++) {
                palindrome = false;
                if(number.charAt(i) == number.charAt(number.length()-1 -i)){
                    palindrome = true;
                } else {
                    break;
                }
            }
        }
        return palindrome;
    }
}
