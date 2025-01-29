package Week1_Stack_And_Queues.Lab;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class SimpleCalculator_02 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        ArrayDeque<String> strStack = new ArrayDeque<>();
        String [] tokens = scan.nextLine().split("\\s+");
        Collections.addAll(strStack, tokens);

//        Arrays.stream(scan.nextLine().split("\\s+"))
//                .forEach(strStack::push);

        while (strStack.size() > 1) {
            int num1 = Integer.parseInt(strStack.pop());
            char oper = strStack.pop().toCharArray()[0];
            int num2 = Integer.parseInt(strStack.pop());
            int result = 0;

            strStack = (ArrayDeque<String>) strStack.reversed();

            if (oper == '+') {
                result = num1 + num2;
            } else {
                result = num1 - num2;
            }
            strStack.push(String.valueOf(result));
        }
        System.out.println(strStack.peek());
    }
}
