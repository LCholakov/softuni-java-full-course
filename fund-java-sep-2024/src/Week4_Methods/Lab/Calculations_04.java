package Week4_Methods.Lab;

import java.util.Scanner;

public class Calculations_04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        switch  (scanner.nextLine()) {
            case "add" -> add(Integer.parseInt(scanner.nextLine()), Integer.parseInt(scanner.nextLine()));
            case "multiply" -> multiply(Integer.parseInt(scanner.nextLine()), Integer.parseInt(scanner.nextLine()));
            case "subtract" -> subtract(Integer.parseInt(scanner.nextLine()), Integer.parseInt(scanner.nextLine()));
            case "divide" -> divide(Integer.parseInt(scanner.nextLine()), Integer.parseInt(scanner.nextLine()));
        }
    }
    private static void add(int a, int b) {
        System.out.println(a + b);
    }
    private static void multiply(int a, int b) {
        System.out.println(a * b);
    }
    private static void subtract(int a, int b) {
        System.out.println(a - b);
    }
    private static void divide(int a, int b) {
        System.out.println(a / b);
    }
}
