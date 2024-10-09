package Week2_DataTypesAndVariables.Exer;

import java.util.Scanner;

public class SumOfChars_04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        byte n = Byte.parseByte(scanner.nextLine());
        short sum = 0;
        for (byte i = 0; i < n; i++) {
            sum += scanner.nextLine().charAt(0);
        }
        System.out.printf("The sum equals: %d", sum);
    }
}
