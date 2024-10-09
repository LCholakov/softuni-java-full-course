package Week6_NestedLoop.DrawingFigures;

import java.util.Scanner;

public class Sunglasses_08
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= n; i++)
        {
            if (i == 1 || i == n)
            {
                for (int j = 0; j < 2 * n; j++)
                {
                    System.out.print("*");
                }
                for (int j = 0; j < n; j++)
                {
                    System.out.print(" ");
                }
                for (int j = 0; j < 2 * n; j++)
                {
                    System.out.print("*");
                }
            }
            else
            {
                System.out.print("*");
                for (int j = 0; j < 2 * n - 2; j++)
                {
                    System.out.print("/");
                }
                System.out.print("*");
                if (i == ((n-1) / 2) + 1)
                {
                    for (int j = 0; j < n; j++)
                    {
                        System.out.print("|");
                    }
                }
                else
                {
                    for (int j = 0; j < n; j++)
                    {
                        System.out.print(" ");
                    }
                }
                System.out.print("*");
                for (int j = 0; j < 2 * n - 2; j++)
                {
                    System.out.print("/");
                }
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
