package Exam;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ChickenSnack {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> moneyStack = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .forEach(moneyStack::push);

        ArrayDeque<Integer> priceQueue = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toCollection(ArrayDeque::new));

        int foods = 0;

        while(!moneyStack.isEmpty() && !priceQueue.isEmpty()){
            int moneyElement = moneyStack.peek();
            int priceElement = priceQueue.peek();

            if(moneyElement == priceElement){
                moneyStack.pop();
                priceQueue.poll();
                foods++;
            } else if(moneyElement > priceElement){
               int change = moneyElement - priceElement;
                moneyStack.pop();
                int next = 0;
                if(!moneyStack.isEmpty()) {
                    next = moneyStack.pop() + change;
                }
                moneyStack.push(next);
                priceQueue.poll();
                foods++;
            } else if (moneyElement < priceElement){
                moneyStack.pop();
                priceQueue.poll();
            }
        }

        if(foods >= 4){
            System.out.println("Gluttony of the day! Henry ate " + foods + " foods.");
        } else if(foods < 4 && foods > 0){
            if (foods == 1){
                System.out.println("Henry ate: " + foods + " food.");
            }
            if(foods > 1){
                System.out.println("Henry ate: " + foods + " foods.");
            }

        } else if (foods <= 0){
            System.out.println("Henry remained hungry. He will try next weekend again.");
        }

    }
}
