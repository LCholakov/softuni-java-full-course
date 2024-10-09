package Week2_DataTypesAndVariables.More;

import java.util.Scanner;

public class FloatingEquality_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double eps = 0.000001;
        double a = Double.parseDouble(scanner.nextLine());
        double b = Double.parseDouble(scanner.nextLine());

        if (Math.abs(a - b) < eps) {
            System.out.println("True");
        } else {
            System.out.println("False");
        }
    }
}
