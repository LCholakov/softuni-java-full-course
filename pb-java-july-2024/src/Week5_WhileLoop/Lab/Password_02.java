package Week5_WhileLoop.Lab;

import java.util.Scanner;

public class Password_02
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        String name = scanner.nextLine();
        String pswd = scanner.nextLine();

        while (!scanner.nextLine().equals(pswd)) {}
        System.out.printf("Welcome %s!", name);
    }
}
