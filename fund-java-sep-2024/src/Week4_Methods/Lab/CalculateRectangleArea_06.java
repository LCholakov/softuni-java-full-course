package Week4_Methods.Lab;

import java.util.Scanner;

public class CalculateRectangleArea_06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(getRectArea(Integer.parseInt(scanner.nextLine()), Integer.parseInt(scanner.nextLine())));
    }

    private static int getRectArea(int a, int b) {
        return a * b;
    }
}
