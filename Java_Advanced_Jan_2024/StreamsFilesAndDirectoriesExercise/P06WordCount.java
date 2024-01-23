package StreamsFilesAndDirectoriesExercise;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class P06WordCount {
    private static final String WORDS_PATH =
            "src/StreamsFilesAndDirectoriesExercise/04. Java-Advanced-Files-and-Streams-Exercises-Resources/words.txt";
    private static final String TEXT_PATH =
            "src/StreamsFilesAndDirectoriesExercise/04. Java-Advanced-Files-and-Streams-Exercises-Resources/text.txt";
    private static final String OUTPUT_PATH =
            "src/StreamsFilesAndDirectoriesExercise/output.txt";
    public static void main(String[] args) {

        try (BufferedReader wordReader = new BufferedReader(new FileReader(WORDS_PATH));
             BufferedReader textReader = new BufferedReader(new FileReader(TEXT_PATH));
             PrintWriter writer = new PrintWriter(OUTPUT_PATH)) {

            String[] wordsArr = wordReader.readLine().split("\\s+");
            Map<String, Integer> wordsMap = new HashMap<>();
            for (String word : wordsArr) {
                wordsMap.put(word, 0);
            }

            String[] textArr = textReader.readLine().split("\\s+");
            for (String word : textArr) {
                if (wordsMap.containsKey(word)) {
                    wordsMap.put(word, wordsMap.get(word) + 1);
                }
            }

            wordsMap
                    .entrySet()
                    .stream()
                    .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                    .forEach(entry -> writer.printf("%s - %d%n", entry.getKey(), entry.getValue()));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
