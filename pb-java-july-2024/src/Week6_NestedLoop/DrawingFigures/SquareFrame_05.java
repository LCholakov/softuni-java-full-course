package Week6_NestedLoop.DrawingFigures;

import java.util.Scanner;

public class SquareFrame_05
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < n; j++)
            {
                if ((i == 0 && j == 0 )
                    || (i == 0 && j == n - 1)
                    || (i == n - 1 && j == n - 1)
                    || (i == n - 1 && j == 0))
                {
                    System.out.print("+ ");
                }
                else if (j == 0 || j == n - 1)
                {
                    System.out.print("| ");
                }
                else
                {
                    System.out.print("- ");
                }
            }
            System.out.println();
        }
    }
}
