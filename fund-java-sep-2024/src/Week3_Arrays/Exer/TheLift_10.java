package Week3_Arrays.Exer;

import java.util.Arrays;
import java.util.Scanner;

public class TheLift_10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // get input from console
        int headCount = Integer.parseInt(scanner.nextLine());
        int[] elevatorsArr = Arrays
                        .stream(scanner.nextLine().split(" "))
                        .mapToInt(e -> Integer.parseInt(e)).toArray();
        byte liftCapacity = 4;

        // nested loops filling up each elevator by adding 1 person on every iteration.
        for (int i = 0; i < elevatorsArr.length; i++) {
            for (int j = elevatorsArr[i]; j < liftCapacity; j++) {
                if (headCount > 0) {
                    ++elevatorsArr[i];
                    --headCount;
                } else {
                    break;
                }
            }
        }

        boolean allLiftsAreFull = true;
        for (int i : elevatorsArr) {
            if (i != liftCapacity)
                allLiftsAreFull = false;
        }

        // print status of elevators
        if (headCount > 0) {
            System.out.printf("There isn't enough space! %d people in a queue!%n", headCount);
        } else if (!allLiftsAreFull){
            System.out.println("The lift has empty spots!");
        }
        for (int n : elevatorsArr) {
            System.out.print(n + " ");
        }
    }
}
