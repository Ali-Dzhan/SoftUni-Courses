package StacksAndQueuesExercise;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

    public class P01 {
        public static void main(String[] args) {

            Scanner scanner = new Scanner(System.in);

            Deque<Integer> stack = new ArrayDeque<>();

            // Add elements to the stack
            Arrays.stream(scanner.nextLine().split("\\s+"))
                    .map(Integer::parseInt)
                    .forEach(stack::push);

            while(!stack.isEmpty()){

                System.out.print(stack.pop() + " ");
            }

        }
    }


