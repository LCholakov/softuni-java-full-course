package Week2_DataTypesAndVariables.Exer;

import java.util.Scanner;

public class Elevator_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        byte n = Byte.parseByte(scanner.nextLine());
        byte p = Byte.parseByte(scanner.nextLine());
//        System.out.println(n / p + Boolean.compare(n % p != 0, false));
        System.out.printf("%.0f", Math.ceil(1.0 * n / p));
    }
}
