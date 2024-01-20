package SetsAndMapsExercise;

import java.util.*;

public class P10LogsAggregator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numOfLogs = Integer.parseInt(scanner.nextLine());
        TreeMap<String, TreeMap<String, Integer>> dictOfUsers = new TreeMap<>();

        for (int i = 0; i < numOfLogs; i++) {
            String[] userInfo = scanner.nextLine().split(" ");
            String IP = userInfo[0];
            String username = userInfo[1];
            int duration = Integer.parseInt(userInfo[2]);

            dictOfUsers.computeIfAbsent(username, k -> new TreeMap<>());
            dictOfUsers.get(username).merge(IP, duration, Integer::sum);
        }

        for (Map.Entry<String, TreeMap<String, Integer>> user : dictOfUsers.entrySet()) {
            int totalDurationOfUser = user.getValue().values().stream().mapToInt(Integer::intValue).sum();
            List<String> listOfIps = new ArrayList<>(user.getValue().keySet());
            System.out.println(user.getKey() +
                    ": " + totalDurationOfUser +
                    " [" + String.join(", ", listOfIps) + "]");
        }
    }
}
