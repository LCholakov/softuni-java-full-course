package Week4_ForLoop.Exer;

import java.util.Scanner;

public class CleverLily_04
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        int age = Integer.parseInt(scanner.nextLine());
        double washMachPrice = Double.parseDouble(scanner.nextLine());
        int toyPrice = Integer.parseInt(scanner.nextLine());

        double bdayMoneyTotal = 0.0;
        int toyCountTotal = 0;
        double sumTotal = 0.0;
        double result = 0.0;

        for (int i = 1; i <= age; ++i)
        {
            if (i % 2 == 0)
            {
                bdayMoneyTotal += (i / 2) * 10.0;
                bdayMoneyTotal -= 1.0;
            }
            else
            {
                ++toyCountTotal;
            }
        }

        sumTotal = bdayMoneyTotal + (toyCountTotal * toyPrice);

        result = sumTotal - washMachPrice;

        if (result >= 0)
        {
            System.out.printf("Yes! %.2f", result);
        }
        else
        {
            System.out.printf("No! %.2f", Math.abs(result));
        }
    }
}
