package Week1_Stack_And_Queues.Exer;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class MaximumElement_03 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        ArrayDeque<Integer> numStack = new ArrayDeque<Integer>();
        for (int i = Integer.parseInt(scan.nextLine()); i > 0; i--) {
            String input []= scan.nextLine().split("\\s+");
            // switch is much neater
            if(input[0].equals("1")) {
                numStack.push(Integer.parseInt(input[1]));
            } else if(input[0].equals("2")) {
                numStack.pop();
            } else if(input[0].equals("3")) {
                System.out.println(Collections.max(numStack));
            }
        }
    }
}
