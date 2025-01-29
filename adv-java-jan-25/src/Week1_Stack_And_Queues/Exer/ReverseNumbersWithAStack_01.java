package Week1_Stack_And_Queues.Exer;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class ReverseNumbersWithAStack_01 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        ArrayDeque<String> strStack = new ArrayDeque<String>();

        Arrays.stream(scan.nextLine().split("\\s+"))
                .forEach(strStack::push);

        while(!strStack.isEmpty()) {
            System.out.print(strStack.remove() + " ");
        }
    }
}
