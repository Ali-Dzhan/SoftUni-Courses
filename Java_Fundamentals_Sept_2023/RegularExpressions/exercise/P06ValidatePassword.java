package RegularExpressions.exercise;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P06ValidatePassword {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String regexPass = "_\\.+(?<passwordText>[A-Z][A-Za-z0-9]{4,}[A-Z])_\\.+";
        Pattern pattern = Pattern.compile(regexPass);

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= n ; i++) {

            String password = scanner.nextLine();
            Matcher matcher = pattern.matcher(password);

            if(matcher.find()){
                String textPassword = matcher.group("passwordText");
                StringBuilder digitCategory = new StringBuilder();
                for (char symbol: textPassword.toCharArray()){
                    if(Character.isDigit(symbol)){
                        digitCategory.append(symbol);
                    }
                }
                if(digitCategory.length() == 0){
                    System.out.println("Group: default");
                }else {
                    System.out.println("Group: " + digitCategory);
                }

            } else{
                System.out.println("Invalid pass!");
            }
        }
    }
}
