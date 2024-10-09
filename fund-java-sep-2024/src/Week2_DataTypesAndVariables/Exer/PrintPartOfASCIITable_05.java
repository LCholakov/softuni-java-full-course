package Week2_DataTypesAndVariables.Exer;

import java.util.Scanner;

public class PrintPartOfASCIITable_05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        short n1 = Short.parseShort(scanner.nextLine());
        short n2 = Short.parseShort(scanner.nextLine());
        for (short i = n1; i <= n2; i++) {
            System.out.print((char)i + " ");
        }
    }
}
