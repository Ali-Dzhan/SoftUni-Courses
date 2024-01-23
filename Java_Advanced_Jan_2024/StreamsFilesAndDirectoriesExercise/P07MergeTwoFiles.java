package StreamsFilesAndDirectoriesExercise;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class P07MergeTwoFiles {
    private static final String INPUT_ONE_PATH =
            "src/StreamsFilesAndDirectoriesExercise/04. Java-Advanced-Files-and-Streams-Exercises-Resources/Exercises Resources/inputOne.txt";
    private static final String INPUT_TWO_PATH =
            "src/StreamsFilesAndDirectoriesExercise/04. Java-Advanced-Files-and-Streams-Exercises-Resources/Exercises Resources/inputTwo.txt";
    private static final String MERGED_PATH =
            "src/StreamsFilesAndDirectoriesExercise/output.txt";
    public static void main(String[] args) {

        try (BufferedReader inputOneReader = new BufferedReader(new FileReader(INPUT_ONE_PATH));
             BufferedReader inputTwoReader = new BufferedReader(new FileReader(INPUT_TWO_PATH));
             PrintWriter mergedFile = new PrintWriter(MERGED_PATH)) {

            String line;
            while ((line = inputOneReader.readLine()) != null) {
                mergedFile.println(line);
            }

            // Merge content from the second file (text.txt)
            while ((line = inputTwoReader.readLine()) != null) {
                mergedFile.println(line);
            }

            System.out.println("Files merged successfully.");


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
