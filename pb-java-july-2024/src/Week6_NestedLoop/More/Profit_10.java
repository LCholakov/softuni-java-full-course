package Week6_NestedLoop.More;

import java.util.Scanner;

public class Profit_10
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        int coin1lv = Integer.parseInt(scanner.nextLine());
        int coin2lv = Integer.parseInt(scanner.nextLine());
        int bill5lv = Integer.parseInt(scanner.nextLine());
        int amount = Integer.parseInt(scanner.nextLine());


        for (int i = 0; i <= coin1lv; ++i)
        {
            for (int j = 0; j <= coin2lv; ++j)
            {
                for (int k = 0; k <= bill5lv; ++k)
                {
                    if (i + 2 * j + 5 * k == amount)
                    {
                        System.out.printf("%d * 1 lv. + %d * 2 lv. + %d * 5 lv. = %d lv.%n", i, j, k, amount);
                    }
                }
            }
        }
    }
}
