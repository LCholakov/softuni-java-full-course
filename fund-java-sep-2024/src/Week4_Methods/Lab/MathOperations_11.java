package Week4_Methods.Lab;

import java.util.Scanner;

public class MathOperations_11 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(calculate(Integer.parseInt(scanner.nextLine())
                                    , scanner.nextLine().charAt(0)
                                    , Integer.parseInt(scanner.nextLine())));
    }

    private static int calculate(int n1, char c, int n2) {
        switch (c) {
            case '+' -> { return n1 + n2; }
            case '*' -> { return n1 * n2; }
            case '-' -> { return n1 - n2; }
            case '/' -> { return n1 / n2; }
            default -> { return 0; }
        }
    }
}
