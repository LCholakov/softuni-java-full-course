package Week6_NestedLoop.DrawingFigures;

import java.util.Scanner;

public class ChristmasTree_07
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i <= n; i++)
        {
            for (int k = 0; k < n - i; k++)
            {
                System.out.print(" ");
            }
            for (int k = 0; k <= i - 1; k++)
            {
                System.out.printf("*");
            }
            System.out.print(" | ");
            for (int k = 0; k <= i - 1; k++)
            {
                System.out.printf("*");
            }
            System.out.println();
        }

    }
}
