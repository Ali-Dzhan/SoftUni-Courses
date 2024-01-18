package SetsAndMaps;

import java.util.*;

public class P08AcademyGraduation {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());

        TreeMap<String, List<Double>> students = new TreeMap<>();

        for (int i = 0; i < number; i++) {
            String name = scanner.nextLine();
            String[] scoresStrings = scanner.nextLine().split(" ");
            Double[] scores = new Double[scoresStrings.length];
            for (int j = 0; j < scoresStrings.length; j++) {
                scores[j] = Double.parseDouble(scoresStrings[j]);
            }
            students.put(name, List.of(scores));
        }

        for (Map.Entry<String, List<Double>> entry : students.entrySet()) {
            String studentName = entry.getKey();
            double averageGrade = entry.getValue().stream().mapToDouble(Double::doubleValue).average().orElse(0);
            System.out.printf("%s is graduated with %s%n", studentName, averageGrade);
        }
    }
}
