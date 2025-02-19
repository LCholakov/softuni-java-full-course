package ExamPrep.ItsChocolateTime_01;

import java.util.*;
import java.util.stream.Collectors;

public class ItsChocolateTime_01 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        ArrayDeque<Double> milkQueue = Arrays
                .stream(scan.nextLine().split("\\s+"))
                .map(Double::parseDouble)
                .collect(Collectors.toCollection(ArrayDeque::new));
        // I seem to not be able to define the stack at declaration.
        ArrayDeque<Double> cocoStack = new ArrayDeque<>();
        Arrays.stream(scan.nextLine().split("\\s+"))
                .map(Double::parseDouble)
                .forEach(cocoStack::push);

        int milkChocoCounter = 0;
        int darkChocoCounter = 0;
        int bakeChocoCounter = 0;

        while (!milkQueue.isEmpty() && !cocoStack.isEmpty()) {
            int cocoPercentage = (int) (100 * cocoStack.peek() / (cocoStack.peek() + milkQueue.peek()));
            switch (cocoPercentage) {
                case 30 -> {
                    milkChocoCounter++;
                    removeVals(milkQueue, cocoStack);
                }
                case 50 -> {
                    darkChocoCounter++;
                    removeVals(milkQueue, cocoStack);
                }
                case 100 -> {
                    bakeChocoCounter++;
                    removeVals(milkQueue, cocoStack);
                }
                default -> {
                    cocoStack.pop();
                    milkQueue.offer(milkQueue.poll() + 10);
                }
            }
        }

        if(milkChocoCounter > 0 && darkChocoCounter > 0 && bakeChocoCounter > 0) {
            System.out.println("It’s a Chocolate Time. All chocolate types are prepared.");
        } else {
            System.out.println("Sorry, but you didn't succeed to prepare all types of chocolates.");
        }
        // my version
//        if (bakeChocoCounter > 0)
//            System.out.println("# Baking Chocolate --> " + bakeChocoCounter);
//        if (darkChocoCounter > 0)
//            System.out.println("# Dark Chocolate --> " + darkChocoCounter);
//        if (milkChocoCounter > 0)
//            System.out.println("# Milk Chocolate --> " + milkChocoCounter);

        // class version

        Map<String, Integer> chocolatesMap = Map.of(
                "Milk Chocolate", milkChocoCounter,
                "Dark Chocolate", darkChocoCounter,
                "Baking Chocolate", bakeChocoCounter);

        chocolatesMap.entrySet()
                .stream()
                .filter(entry -> entry.getValue() != 0)
                .sorted(Comparator.comparing(Map.Entry::getKey))
                .forEach(entry -> {
                    System.out.printf("# %s --> %d%n", entry.getKey(), entry.getValue());
                });
    }

    private static void removeVals(ArrayDeque<Double> milkQueue, ArrayDeque<Double> cocoStack) {
        milkQueue.poll();
        cocoStack.pop();
    }
}
