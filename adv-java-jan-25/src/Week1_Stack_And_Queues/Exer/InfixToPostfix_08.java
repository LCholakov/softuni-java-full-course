package Week1_Stack_And_Queues.Exer;

import java.util.ArrayDeque;
import java.util.Scanner;

public class InfixToPostfix_08 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        ArrayDeque<String> pfStack = new ArrayDeque<>();

        String[] input = scan.nextLine().split("\\s+");

        for (String tok : input) {
            if (Character.isLetterOrDigit(tok.toCharArray()[0])) {
                System.out.print(tok + " ");
            } else if (tok.equals("(")) {
                pfStack.push(tok);
            } else if (tok.equals(")")) {
                while (!pfStack.isEmpty() && !pfStack.peek().equals("(")) {
                    System.out.print(pfStack.pop() + " ");
                }
                pfStack.pop();
            } else {
                while (!pfStack.isEmpty() && precedence(tok) <= precedence(pfStack.peek())) {
                    System.out.print(pfStack.pop() + " ");
                }
                pfStack.push(tok);
            }
        }
        while (!pfStack.isEmpty()) {
            System.out.print(pfStack.pop() + " ");
        }
    }

    private static boolean isOperator(String tok) {
        return tok.equals("+") || tok.equals("-") || tok.equals("*") || tok.equals("/");
    }

    private static int precedence(String oper) {
        switch (oper) {
            case "-", "+" -> {
                return 1;
            }
            case "*", "/" -> {
                return 2;
            }
        }
        return -1;
    }
}
