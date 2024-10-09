package Week4_Methods.Lab;

import java.util.Scanner;

public class SignOfIntegerNumbers_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        printIntSign(Integer.parseInt(scanner.nextLine()));

    }

    private static void printIntSign(int i) {
        if (i > 0) {
            System.out.printf("The number %d is positive.", i);
        } else if (i < 0) {
            System.out.printf("The number %d is negative.", i);
        } else {
            System.out.printf("The number %d is zero.", i);
        }
    }
}
