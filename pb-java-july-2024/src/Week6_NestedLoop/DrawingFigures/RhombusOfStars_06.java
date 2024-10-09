package Week6_NestedLoop.DrawingFigures;

import java.util.Scanner;

public class RhombusOfStars_06
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= n; i++)
        {
            for (int k = 0; k < n - i; k++)
            {
                System.out.print(" ");
            }
            System.out.printf("* ");
            for (int k = 0; k < i - 1; k++)
            {
                System.out.printf("* ");
            }
        System.out.println();
        }

        for (int i = n - 1; i > 0 ; i--)
        {
            for (int k = 0; k < n - i; k++)
            {
                System.out.print(" ");
            }
            System.out.printf("* ");
            for (int k = 0; k < i - 1; k++)
            {
                System.out.printf("* ");
            }
            System.out.println();
        }
    }
}
