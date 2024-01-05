package RegularExpressions.exercise;


import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P05NetherRealms {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] demonNames = scanner.nextLine().split("\\s*,\\s*");

        for (String demon : demonNames) {
            double baseDamage = getDemonsDamage(demon);
            int health = getDemonsHealth(demon);

            System.out.printf("%s - %d health, %.2f damage%n",demon,health,baseDamage);


        }
    }

    private static int getDemonsHealth(String demonName){

        int health = 0;
        Pattern pattern = Pattern.compile("[^0-9*\\/. ,+\\-]");
        Matcher matcher = pattern.matcher(demonName);

       while(matcher.find()){
          health +=  (int) matcher.group().charAt(0);
       }
       return health;
    }

    private static double getDemonsDamage(String demonName){

        Pattern digits = Pattern.compile("[+-]?\\d+[\\.]?\\d*");
        Matcher matchDigit = digits.matcher(demonName);
        Pattern multiDivide = Pattern.compile("[*/]");
        Matcher matchMultiDivide = multiDivide.matcher(demonName);

        double damage = 0;

        while(matchDigit.find()){
            damage += Double.parseDouble(matchDigit.group());
        }
        while(matchMultiDivide.find()){
            if(matchMultiDivide.group().equals("*")){
                damage *= 2;
            } else if (matchMultiDivide.group().equals("/")) {
                damage /= 2;
            }

        }
        return  damage;
    }
}
