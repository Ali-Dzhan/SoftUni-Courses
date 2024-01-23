package StreamsFilesAndDirectoriesExercise;

import java.io.File;

public class P08GetFolderSize {
    public static void main(String[] args) {
        String path = "src/StreamsFilesAndDirectoriesExercise/04. Java-Advanced-Files-and-Streams-Exercises-Resources/Exercises Resources";

        File file = new File(path);
        int sum = 0;
        if(file.isDirectory()){
            for (File listFile : file.listFiles()) {

                sum += listFile.length();

            }
            System.out.printf("Folder size: %d", sum);
        }
    }
}
