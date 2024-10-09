package Week4_Methods.Exer;

import java.util.Scanner;

public class AddAndSubtract_05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(subtract(sum(Integer.parseInt(scanner.nextLine()), Integer.parseInt(scanner.nextLine()))
                                    , Integer.parseInt(scanner.nextLine())));
    }

    private static int sum(int a, int b) {
        return a + b;
    }
    private static int subtract(int a, int b) {
        return a - b;
    }
}
