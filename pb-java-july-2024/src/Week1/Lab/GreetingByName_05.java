package Week1.Lab;

import java.util.Scanner;

public class GreetingByName_05
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        String name = scanner.nextLine();

        System.out.print("Hello, " + name + "!");
    }
}
