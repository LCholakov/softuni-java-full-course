package Week5_WhileLoop.Lab;

import java.util.Scanner;

public class AccountBalance_05
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        double amount = 0.0;
        double sum = 0.0;
        while (true)
        {
            String str = scanner.nextLine();
            if (str.equals("NoMoreMoney"))
            {
                break;
            }
            amount = Double.parseDouble(str);
            if (amount < 0)
            {
                System.out.println("Invalid operation!");
                break;
            }
            else
            {
                sum += amount;
                System.out.printf("Increase: %.2f%n", amount);
            }
        }

        System.out.printf("Total: %.2f%n", sum);
    }
}
