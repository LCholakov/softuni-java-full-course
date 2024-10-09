package Week3_Conditionals2.Lab;

import java.util.Scanner;

public class InvalidNumber_10
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        if (n != 0 && (n < 100 || n > 200))
        {
            System.out.println("invalid");
        }
    }
}
