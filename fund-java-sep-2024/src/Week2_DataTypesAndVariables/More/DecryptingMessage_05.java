package Week2_DataTypesAndVariables.More;

import java.util.Scanner;

public class DecryptingMessage_05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        byte key = Byte.parseByte(scanner.nextLine());
        byte n = Byte.parseByte(scanner.nextLine());
        String result = "";
        for (byte i = 0; i < n; i++) {
            result = result + (char)(scanner.nextLine().charAt(0) + key);
        }
        System.out.println(result);
    }
}
