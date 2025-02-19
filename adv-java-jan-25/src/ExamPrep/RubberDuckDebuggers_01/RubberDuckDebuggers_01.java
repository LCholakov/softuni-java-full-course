package ExamPrep.RubberDuckDebuggers_01;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class RubberDuckDebuggers_01 {
    static final String vaderDuckyStr = "Darth Vader Ducky";
    static final String thorDuckyStr = "Thor Ducky";
    static final String blueDuckyStr = "Big Blue Rubber Ducky";
    static final String yellowDuckyStr = "Small Yellow Rubber Ducky";
    static final String over240 = "over 240";

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        // QUEUE
        ArrayDeque<Integer> timeQueue = Arrays
                .stream(scan.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayDeque::new));

        // STACK
        ArrayDeque<Integer> qtyStack = new ArrayDeque<>();
        Arrays.stream(scan.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .forEach(qtyStack::push);

        int vaderDuckyCount = 0;
        int thorDuckyCount = 0;
        int blueDuckyCount = 0;
        int yellowDuckyCount = 0;

        while (!timeQueue.isEmpty() && !qtyStack.isEmpty()) {
            switch (getDuckyType(timeQueue.peek() * qtyStack.peek())) {
                case vaderDuckyStr -> {
                    timeQueue.poll();
                    qtyStack.pop();
                    vaderDuckyCount ++;
                }
                case thorDuckyStr -> {
                    timeQueue.poll();
                    qtyStack.pop();
                    thorDuckyCount ++;
                }
                case blueDuckyStr -> {
                    timeQueue.poll();
                    qtyStack.pop();
                    blueDuckyCount ++;
                }
                case yellowDuckyStr -> {
                    timeQueue.poll();
                    qtyStack.pop();
                    yellowDuckyCount ++;
                }
                default -> {
                    qtyStack.push(qtyStack.pop() - 2);
                    timeQueue.offer(timeQueue.poll());
                }
            }
        }

        System.out.println("Congratulations, all tasks have been completed! Rubber ducks rewarded:");
        System.out.printf("%s: %d%n", vaderDuckyStr, vaderDuckyCount);
        System.out.printf("%s: %d%n", thorDuckyStr, thorDuckyCount);
        System.out.printf("%s: %d%n", blueDuckyStr, blueDuckyCount);
        System.out.printf("%s: %d%n", yellowDuckyStr, yellowDuckyCount);
    }

    private static String getDuckyType(int val) {
        if (0 <= val && val <= 60) {
            return vaderDuckyStr;
        } else if (61 <= val && val <= 120) {
            return thorDuckyStr;
        } else if (121 <= val && val <= 180) {
            return blueDuckyStr;
        } else if (181 <= val && val <= 240) {
            return yellowDuckyStr;
        } else {
            return over240;
        }
    }
}
