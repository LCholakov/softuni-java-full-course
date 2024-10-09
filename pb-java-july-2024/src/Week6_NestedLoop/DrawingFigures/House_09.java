package Week6_NestedLoop.DrawingFigures;

import java.util.Scanner;

public class House_09
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        String roof = "*";
        // draw roof
        for (int i = 0; i < (n + 1) / 2; i++)
        {
            // padding
            for (int j = ((n + 1) / 2) - i; j > 1; j--)
            {
                System.out.print("-");
            }
            // roof
            if (n % 2 == 0)
                roof = "**";
            else
                roof = "*";

            for (int j = 0; j < i; j++)
            {
                roof += "**";
            }
            System.out.print(roof);

            //draw padding
            for (int j = ((n + 1) / 2) - i; j > 1; j--)
            {
                System.out.print("-");
            }
            System.out.println();
        }

        // draw wall
        for (int i = 0; i <= n / 2 - 1; i++)
        {
            for (int j = 0; j < n; j++)
            {
                if (j == 0 || j == n - 1)
                    System.out.print("|");
                else
                    System.out.print("*");
            }
            System.out.println();
        }

    }
}
