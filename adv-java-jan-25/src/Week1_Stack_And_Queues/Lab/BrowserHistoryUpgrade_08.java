package Week1_Stack_And_Queues.Lab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class BrowserHistoryUpgrade_08 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        ArrayDeque<String> backStack = new ArrayDeque<>();
        ArrayDeque<String> fwdStack = new ArrayDeque<>();

        String input = scan.nextLine();
        while (!input.equals("Home")) {
            if(input.equals("back")) {
                if(backStack.size() <= 1) {
                    System.out.println("no previous URLs");
                } else {
                    fwdStack.push(backStack.pop());
                    System.out.println(backStack.peek());
                }
            } else if (input.equals("forward")) {
                if (fwdStack.isEmpty()) {
                    System.out.println("no next URLs");
                } else {
                    backStack.push(fwdStack.pop());
                    System.out.println(backStack.peek());
                }
            } else {
                fwdStack.clear();
                backStack.push(input);
                System.out.println(backStack.peek());
            }
            input = scan.nextLine();
        }
    }
}
