package ExamPreparation.StacksAndQueues;

import java.util.*;

public class QueueStack_FoodFinder {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] words = new String[]{"pear", "flour", "pork", "olive"};
        String[] foundWords = new String[]{"****", "*****", "****", "*****"};

        ArrayDeque<Character> vowels = new ArrayDeque<>();
        for (String s : scanner.nextLine().split("\\s+")) {
            vowels.offer(s.charAt(0));
        }

        ArrayDeque<Character> consonants = new ArrayDeque<>();
        for (String e : scanner.nextLine().split("\\s+")) {
            consonants.offer(e.charAt(0));
        }

        while (!consonants.isEmpty()) {
            char vowel = vowels.poll();
            char consonant = consonants.pop();

            for (int i = 0; i < words.length; i++) {
                String word = words[i];
                int indexVowel = word.indexOf(vowel);
                int indexConsonant = word.indexOf(consonant);
                if (indexVowel >= 0) {
                    foundWords[i] = foundWords[i].substring(0, indexVowel) + vowel + foundWords[i].substring(indexVowel + 1);
                }
                if (indexConsonant >= 0) {
                    foundWords[i] = foundWords[i].substring(0, indexConsonant) + consonant + foundWords[i].substring(indexConsonant + 1);
                }
            }
            vowels.offer(vowel);
        }

        List<String> output = new ArrayList<>();
        for (String w : foundWords) {
            if (!w.contains("*")) {
                output.add(w);
            }
        }

        System.out.printf("Words found: %d%n", output.size());
        output.forEach(System.out::println);
    }
}
