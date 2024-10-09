package Week4_Methods.More;

import java.util.Scanner;

public class MultiplicationSign_05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        printSign(Integer.parseInt(scanner.nextLine())
                , Integer.parseInt(scanner.nextLine())
                , Integer.parseInt(scanner.nextLine()));
    }

    private static void printSign(int a, int b, int c) {
        if(a == 0 || b == 0 || c == 0) {
            System.out.println("zero");
        } else {
            byte minusCounter = 0;
            int [] numsArr = {a, b, c};
            for (int i = 0; i < numsArr.length; i++) {
                if(numsArr[i] < 0)
                    minusCounter++;
            }
            if (minusCounter % 2 == 0)
                System.out.println("positive");
            else
                System.out.println("negative");
        }
    }
}
