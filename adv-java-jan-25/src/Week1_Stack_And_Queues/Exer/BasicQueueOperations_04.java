package Week1_Stack_And_Queues.Exer;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class BasicQueueOperations_04 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();
        int s = scan.nextInt();
        int x = scan.nextInt();

        ArrayDeque<Integer> numQueue = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            numQueue.offer(scan.nextInt());
        }
        for (int i = 0; i < s; i++) {
            numQueue.poll();
        }
        if (numQueue.isEmpty()) {
            System.out.println(0);
        } else if (numQueue.contains(x)) {
            System.out.println(true);
        } else {
            System.out.println(Collections.min(numQueue));
        }
    }
}
