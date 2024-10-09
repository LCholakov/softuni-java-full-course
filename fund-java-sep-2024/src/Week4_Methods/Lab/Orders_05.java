package Week4_Methods.Lab;

import java.util.Scanner;

public class Orders_05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        orderPrice(scanner.nextLine(), Integer.parseInt(scanner.nextLine()));
    }

    private static void orderPrice(String s, int n) {
        switch (s) {
            case "coffee" -> System.out.printf("%.2f", n * 1.5);
            case "water" -> System.out.printf("%.2f", n * 1.0);
            case "coke" -> System.out.printf("%.2f", n * 1.4);
            case "snacks" -> System.out.printf("%.2f", n * 2.0);
        }
    }
}
