package Week3_Conditionals2.Lab;

import java.util.Scanner;

public class NumberInRange_06
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        double n = Double.parseDouble(scanner.nextLine());

        if (n >= -100 && n <= 100 && n != 0)
        {
            System.out.println("Yes");
        }
        else
        {
            System.out.println("No");
        }
    }
}