package Week1_Stack_And_Queues.Lab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class DecimalToBinary_03 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ArrayDeque<Integer> intStack = new ArrayDeque<>();

        int numDec = Integer.parseInt(scan.nextLine());
        if (numDec == 0) {
            System.out.println(0);
        } else {
            while (numDec > 0) {
                intStack.push(numDec % 2);
                numDec /= 2;
            }
            intStack.forEach(n -> System.out.print(n));
        }
    }
}
