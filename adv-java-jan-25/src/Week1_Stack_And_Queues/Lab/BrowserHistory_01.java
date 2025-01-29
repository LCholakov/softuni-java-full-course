package Week1_Stack_And_Queues.Lab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class BrowserHistory_01 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        ArrayDeque<String> strStack = new ArrayDeque<>();

        String input = scan.nextLine();
        while (!input.equals("Home")) {
            if(input.equals("back")) {
                if(strStack.size() <= 1) {
                    System.out.println("no previous URLs");
                } else {
                    strStack.pop();
                    System.out.println(strStack.peek());
                }
            } else {
                strStack.push(input);
                System.out.println(strStack.peek());
            }
            input = scan.nextLine();
        }
    }
}
