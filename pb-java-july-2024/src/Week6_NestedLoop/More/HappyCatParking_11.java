package Week6_NestedLoop.More;

import java.util.Scanner;

public class HappyCatParking_11
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        int days = Integer.parseInt(scanner.nextLine());
        int hours = Integer.parseInt(scanner.nextLine());

        double evenDoddHprice = 2.5;
        double oddDevenHprice = 1.25;
        double regularPrice = 1.0;
        double currDayAmount = 0.0;
        double totalAmount = 0.0;

        for (int i = 1; i <= days; i++)
        {
            for (int j = 1; j <= hours; j++)
            {
                if (i % 2 == 0 && j % 2 != 0)
                    currDayAmount += evenDoddHprice;
                else if (i % 2 != 0 && j % 2 == 0)
                    currDayAmount += oddDevenHprice;
                else
                    currDayAmount += regularPrice;
            }

            System.out.printf("Day: %d - %.2f leva%n", i, currDayAmount);
            totalAmount += currDayAmount;
            currDayAmount = 0;
        }

        System.out.printf("Total: %.2f leva", totalAmount);
    }
}
