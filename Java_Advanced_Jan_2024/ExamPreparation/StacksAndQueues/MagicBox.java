package ExamPreparation.StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MagicBox {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // queue
        ArrayDeque<Integer> firstBox = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayDeque::new));

        //stack

        ArrayDeque<Integer> secondBox = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .forEach(secondBox::push);

        int claimedItems = 0;
        while(!firstBox.isEmpty() && !secondBox.isEmpty()){
            int first = firstBox.peek();
            int second = secondBox.pop();

            int sum = first + second;

            if(sum % 2 == 0){
                claimedItems += sum;
                firstBox.poll();
            } else{
                firstBox.offer(second);
            }
        }

        String emptyBoxOutput = firstBox.isEmpty() ? "First magic box is empty."
                : "Second magic box is empty.";

        String itemsValueOutput = claimedItems >= 90 ? "Wow, your prey was epic! Value: "
                : "Poor prey... Value: ";

        System.out.println(emptyBoxOutput);
        System.out.println(itemsValueOutput + claimedItems);
    }
}
