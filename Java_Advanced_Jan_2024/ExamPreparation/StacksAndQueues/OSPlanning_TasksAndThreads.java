package ExamPreparation.StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class OSPlanning_TasksAndThreads {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //stack
        ArrayDeque<Integer> taskStack = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(", "))
                .map(Integer::parseInt)
                .forEach(taskStack::push);
        //queue
        ArrayDeque<Integer> threadsQueue = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayDeque::new));

        int value = Integer.parseInt(scanner.nextLine());

        while(!threadsQueue.isEmpty()){
            int task = taskStack.peek();
            int thread = threadsQueue.peek();
            if (task == value){
                break;
            }else {
                if (thread >= task) {
                    taskStack.pop();
                    threadsQueue.poll();
                } else {
                    threadsQueue.poll();
                }
            }
        }
        System.out.println("Thread with value " + threadsQueue.peek() + " killed task " + value);
        threadsQueue.forEach(e -> System.out.print(e + " "));
    }
}
