package Week4_Methods.Exer;

import java.util.Scanner;

public class SmallestOfThreeNumbers_01 {
    private static void printSmallest(int a, int b, int c) {
        System.out.println(Math.min(a, Math.min(b, c)));
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        printSmallest(Integer.parseInt(scanner.nextLine())
                        , Integer.parseInt(scanner.nextLine())
                        , Integer.parseInt(scanner.nextLine()));
    }
}
