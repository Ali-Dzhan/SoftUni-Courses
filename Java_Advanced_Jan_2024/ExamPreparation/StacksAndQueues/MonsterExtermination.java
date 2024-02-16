package ExamPreparation.StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

public class MonsterExtermination {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // monsters queue
        Deque<Integer> monstersQueue = new ArrayDeque<>();
        // strikes stack
        Deque<Integer> strikesStack = new ArrayDeque<>();

        Arrays.stream(scanner.nextLine().split(","))
                .map(Integer::parseInt)
                .forEach(monstersQueue::offer);

        Arrays.stream(scanner.nextLine().split(","))
                .map(Integer::parseInt)
                .forEach(strikesStack::push);

        int killedMonsters = 0;
        //•	The battle goes on until one of the sequences becomes empty
        while (!monstersQueue.isEmpty() && !strikesStack.isEmpty()) {

            int armour = monstersQueue.poll();
            int strike = strikesStack.pop();

            // If the soldier's striking impact is greater than or equal to the monster's armor
            if (strike >= armour) {
                killedMonsters++;
                strike -= armour;

                if (strike > 0) {
                    if (!strikesStack.isEmpty()) {
                        strike += strikesStack.pop();
                    }
                    strikesStack.push(strike);
                }

            } else {
                armour -= strike;
                monstersQueue.offer(armour);
            }
        }

        if (monstersQueue.isEmpty()) {
            System.out.println("All monsters have been killed!");
        }

        if (strikesStack.isEmpty()) {
            System.out.println("The soldier has been defeated.");
        }

        System.out.printf("Total monsters killed: %d", killedMonsters);
    }
}
