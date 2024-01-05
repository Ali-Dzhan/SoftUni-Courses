package ExamPrepFinal1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P09MirrorWords {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Pattern pattern = Pattern.compile("(@|#)(?<wordOne>[A-Za-z]{3,})\\1\\1(?<wordTwo>[A-Za-z]{3,})\\1");
        Matcher matcher = pattern.matcher(input);
        List<String> mirrorWord = new ArrayList<>();
        int PairCounter = 0;
        boolean haveMatch = false;

        while(matcher.find()){

            String wordOne = matcher.group("wordOne");
            String wordTwo = matcher.group("wordTwo");

            StringBuilder reversedWord = new StringBuilder(wordTwo);
            reversedWord.reverse();
            PairCounter++;
            haveMatch = true;

            if (wordOne.equals(reversedWord.toString())) {
                mirrorWord.add(wordOne + " <=> " + wordTwo);
            }
        }

        if(haveMatch) {
            System.out.printf("%d word pairs found!%n", PairCounter);
        }else{
            System.out.println("No word pairs found!");
        }


        if (mirrorWord.isEmpty()){
            System.out.println("No mirror words!");
        } else {
            System.out.println("The mirror words are:");
            System.out.println(mirrorWord.toString().replaceAll("[\\[\\]]",""));
        }
    }
}
