package ExamPreparation.StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class TulipsDaffodils {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // stack

        ArrayDeque<Integer> tulipStack = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(", "))
                .map(Integer::parseInt)
                .forEach(tulipStack::push);

        // queue

        ArrayDeque<Integer> daffodilQueue = Arrays.stream(scanner.nextLine().split(", "))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayDeque::new));

        int bouquets = 0;
        int stored = 0;

        while(!tulipStack.isEmpty() && !daffodilQueue.isEmpty()){
            int tulips = tulipStack.peek();
            int daffodils = daffodilQueue.peek();

            int sum = tulips + daffodils;

            if(sum == 15){
                tulipStack.pop();
                daffodilQueue.poll();
                bouquets++;
            } else if(sum > 15){
                int currentTulip = tulipStack.pop() - 2;
                tulipStack.push(Integer.max(currentTulip, 0));
            } else if(sum < 15){
                stored += tulipStack.pop();
                stored += daffodilQueue.poll();
            }
        }
        // making as many bouquets as possible with the stored flowers
        bouquets += stored / 15;

        if(bouquets >= 5){
            System.out.print("You made it! You go to the competition with " + bouquets + " bouquets!\n");
        } else {
            int moreBouquets = 5 - bouquets;
            System.out.printf("You failed... You need more %d bouquets.", moreBouquets);
        }
    }
}
