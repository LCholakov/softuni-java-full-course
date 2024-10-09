package Week4_ForLoop.More;

import java.util.Scanner;

public class BackToThePast_01
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        double inheritance = Double.parseDouble(scanner.nextLine());
        int endYear = Integer.parseInt(scanner.nextLine());

        int tempAge = 18 - 1;  // first loop increments to 18 in 1800, so we start at 17
        double neededMoney = 0;
        double result = 0.0;

        for (int i = 1800; i <= endYear; ++i)
        {
            tempAge += 1;
            if (i % 2 == 0)
            {
                neededMoney += 12000;
            }
            else
            {
                neededMoney += 12000 + (50 * tempAge);
            }
        }

        result = inheritance - neededMoney;

        if (result >= 0)
        {
            System.out.printf("Yes! He will live a carefree life and will have %.2f dollars left.", result);
        }
        else
        {
            System.out.printf("He will need %.2f dollars to survive.", Math.abs(result));
        }
    }
}
