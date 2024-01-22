package StreamsFilesAndDirectories;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class P06SortLines {
    public static void main(String[] args) throws IOException {

        String inputPath = "src/StreamsFilesAndDirectories/input.txt";
        String outputPath = "src/StreamsFilesAndDirectories/06.SortLinesOutput.txt";

        List<String> lines = Files.readAllLines(Paths.get(inputPath));

        Collections.sort(lines);

        Files.write(Paths.get(outputPath), lines);
    }
}
