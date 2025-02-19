package Week4_IteratorsAndComparators.Exer.StackIterator;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        CustomStack customStack = new CustomStack();

        String cmd = scan.nextLine();
        while (!cmd.equals("END")) {
            if (cmd.equals("Pop")) {
                customStack.pop();
            } else {
                int [] nArr = Arrays
                        .stream(cmd.replace("Push ", "").split(", "))
                        .mapToInt(Integer::parseInt)
                        .toArray();

                for (int n : nArr) {
                    customStack.push(n);
                }
            }

            cmd = scan.nextLine();
        }

        for (Integer n : customStack) {
            System.out.println(n);
        }
        for (Integer n : customStack) {
            System.out.println(n);
        }
    }
}
