package StreamsFilesAndDirectoriesExercise;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class P01SumLines {
    private static final String PATH = "src/StreamsFilesAndDirectoriesExercise/04. Java-Advanced-Files-and-Streams-Exercises-Resources/input.txt";

    public static void main(String[] args) {

        try (BufferedReader reader = new BufferedReader(new FileReader(PATH))) {
            String line = reader.readLine();

            while (line != null) {
                long sum = 0;

                for (char c : line.toCharArray()) {
                    sum += c;
                }
                System.out.println(sum);
                line = reader.readLine();
            }

        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }
}
