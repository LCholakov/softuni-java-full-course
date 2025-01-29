package Week1_Stack_And_Queues.Lab;

import java.util.*;

public class HotPotato_06 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        ArrayDeque<String> namesQueue = new ArrayDeque<>();
        Arrays.stream(scan.nextLine().split("\\s+"))
                .forEach(namesQueue::offer);
//        Collections.addAll(namesQueue, scan.nextLine().split("\\s+"));
        int n = Integer.parseInt(scan.nextLine());

        int counter = 0;
        while (namesQueue.size() > 1) {
            String currName = namesQueue.poll();
            counter++;
            if (counter % n == 0) {
                System.out.println("Removed " + currName);
            } else {
                namesQueue.offer(currName);
            }
        }
        System.out.println("Last is " + namesQueue.poll());
    }
}
