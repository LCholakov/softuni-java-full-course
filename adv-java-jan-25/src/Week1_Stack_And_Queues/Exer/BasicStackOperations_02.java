package Week1_Stack_And_Queues.Exer;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class BasicStackOperations_02 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();
        int s = scan.nextInt();
        int x = scan.nextInt();

        ArrayDeque<Integer> numStack = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            numStack.push(scan.nextInt());
        }
        for (int i = 0; i < s; i++) {
            numStack.pop();
        }
        if (numStack.isEmpty()) {
            System.out.println(0);
        } else if (numStack.contains(x)) {
            System.out.println(true);
        } else {
            System.out.println(Collections.min(numStack));
        }
    }
}
