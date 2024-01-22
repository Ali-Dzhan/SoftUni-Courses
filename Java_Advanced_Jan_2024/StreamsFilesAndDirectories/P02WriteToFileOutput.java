package StreamsFilesAndDirectories;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class P02WriteToFileOutput {
    public static void main(String[] args) throws IOException {

        String path = "src/StreamsFilesAndDirectories/input.txt";

        FileInputStream inputStream = new FileInputStream(path);

        FileOutputStream outputStream = new FileOutputStream("src/StreamsFilesAndDirectories/02.WriteToFileOutput.txt");

        Set<Character> punctuations = new HashSet<>();
        punctuations.add(',');
        punctuations.add('.');
        punctuations.add('!');
        punctuations.add('?');

        int singleByte = inputStream.read();

        while (singleByte >= 0) {
            char symbol = (char) singleByte;

            if (!punctuations.contains(symbol)) {
                outputStream.write(symbol);
            }

            singleByte = inputStream.read();
        }

        inputStream.close();
        outputStream.close();
    }
}
