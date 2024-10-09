package Week4_Methods.Lab;

import Week2_DataTypesAndVariables.More.DecryptingMessage_05;

import java.text.DecimalFormat;
import java.util.Scanner;

public class MathPower_08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//        System.out.println(mathPow(Integer.parseInt(scanner.nextLine()), Integer.parseInt(scanner.nextLine())));
        double number = Double.parseDouble(scanner.nextLine());
        int power = Integer.parseInt(scanner.nextLine());
        String result = new DecimalFormat("0.####").format(mathPow(number, power));

    }

    private static long mathPow(int a, int b) {
//        return (long) Math.round(Math.pow(a, b));
        long result = 1;
        for (int i = 0; i < b; i++) {
            result *= a;
        }
        return result;
    }
    private static double mathPow(double a, int b) {
        return Math.pow(a, b);
    }
}
