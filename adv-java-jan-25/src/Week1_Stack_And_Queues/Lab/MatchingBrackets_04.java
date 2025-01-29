package Week1_Stack_And_Queues.Lab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class MatchingBrackets_04 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        ArrayDeque<Integer> idxStack = new ArrayDeque<>();

        String input = scan.nextLine();
        for (int i = 0; i < input.length(); i++) {
            char c = input.toCharArray()[i];
            if (c == '(') {
                idxStack.push(i);
            } else if (c == ')') {
                System.out.println(input.substring(idxStack.pop(), i + 1));
            }
        }
    }
}
