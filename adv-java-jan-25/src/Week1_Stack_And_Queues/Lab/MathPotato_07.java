package Week1_Stack_And_Queues.Lab;

import java.util.*;

public class MathPotato_07 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        PriorityQueue<String> namesQueue = new PriorityQueue<>();
//        Arrays.stream(scan.nextLine().split("\\s+"))
//                .forEach(namesQueue::offer);
        Collections.addAll(namesQueue, scan.nextLine().split("\\s+"));
        int n = Integer.parseInt(scan.nextLine());

        int counter = 0;
        while (namesQueue.size() > 1) {
            String currName = namesQueue.poll();
            counter++;
            if (isPrime(counter)) {
                System.out.println("Prime " + currName);
                namesQueue.offer(currName);
            } else {
                System.out.println("Removed " + currName);
            }
        }
        System.out.println("Last is " + namesQueue.poll());

    }

    private static boolean isPrime(int n) {
        if (n == 1) {
            return false;
        }
        for (int i = 2; i < n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
