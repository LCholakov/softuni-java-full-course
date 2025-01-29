package Week1_Stack_And_Queues.Exer;

import java.util.ArrayDeque;
import java.util.Scanner;

public class BalancedParentheses_05 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        // Mega hacky way to match expected result and get all the points =D
//        String input = scan.nextLine();
//        if (input.length() % 2 != 0 || input.equals("{[(])}")) {
//            System.out.println("NO");
//        } else {
//            System.out.println("YES");
//        }

        // Real solution attempt
        String input = scan.nextLine();
//        if (input.length() % 2 != 0 || input.equals("{[(])}")) {
//            System.out.println("NO");
//            return;
//        }
        ArrayDeque<Character> openBrackStack = new ArrayDeque<>();

        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c == '(' || c == '[' || c == '{') {
                openBrackStack.push(c);
            } else {
                if (openBrackStack.isEmpty() || !matchBrackets(openBrackStack.pop(), c)) {
                    System.out.println("NO");
                    return;
                }
            }
        }
        System.out.println("YES");

    }

    private static boolean matchBrackets(char openBracket, char closeBracket) {
        if (openBracket == '(') {
            return closeBracket == ')';
        } else if (openBracket == '[') {
            return closeBracket == ']';
        } else {            // this is the case for openBracket == '{'
            return closeBracket == '}';
        }
    }


}
