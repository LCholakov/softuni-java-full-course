package Week2_DataTypesAndVariables.Exer;

import java.util.Scanner;

public class IntegerOperations_01 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n1 = Integer.parseInt(scanner.nextLine());
        int n2 = Integer.parseInt(scanner.nextLine());
        int n3 = Integer.parseInt(scanner.nextLine());
        int n4 = Integer.parseInt(scanner.nextLine());

        System.out.println(((n1 + n2) / n3) * n4);
    }
}
