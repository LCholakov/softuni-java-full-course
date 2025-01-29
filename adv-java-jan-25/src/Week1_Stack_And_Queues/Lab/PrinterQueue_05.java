package Week1_Stack_And_Queues.Lab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class PrinterQueue_05 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        ArrayDeque<String> strQueue = new ArrayDeque<>();
        String input = scan.nextLine();
        while (!input.equals("print")) {
            if (input.equals("cancel")) {
                if(strQueue.size() > 0) {
                    System.out.println("Canceled " + strQueue.remove());
                } else {
                    System.out.println("Printer is on standby");
                }
            } else {
                strQueue.offer(input);
            }
            input = scan.nextLine();
        }

        strQueue.forEach(s -> System.out.println(s));
    }
}
