package Week5_WhileLoop.More;

import java.util.Scanner;

public class Dishwasher_01
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        int bottleContent = 750;
        int plateUsage = 5;
        int potUsage = 15;

        // 1st = plates; 2nd = plates; 3rd = pots

        int availableLiquid = 750 * Integer.parseInt(scanner.nextLine());
        int i = 0;      // number of washes
        int usedLiquid = 0;
        int x = 0;      // number of plates or pots
        int plateCount = 0;
        int potCount = 0;

        while (usedLiquid <= availableLiquid)
        {
            String input = scanner.nextLine();
            if (input.equals("End")) { break; }
            x = Integer.parseInt(input);

            ++i;
            if (i % 3 == 0)
            {
                potCount += x;
                usedLiquid += x * potUsage;
            }
            else
            {
                plateCount += x;
                usedLiquid += x * plateUsage;
            }
        }

        if (usedLiquid > availableLiquid)
        {
            System.out.printf("Not enough detergent, %d ml. more necessary!", usedLiquid - availableLiquid);
        }
        else
        {
            System.out.println("Detergent was enough!");
            System.out.printf("%d dishes and %d pots were washed.%n", plateCount, potCount);
            System.out.printf("Leftover detergent %d ml.", availableLiquid - usedLiquid);
        }
    }
}
