package Week6_NestedLoop.DrawingFigures;

import java.util.Scanner;

public class RectangleOfNxNStars_02
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < n; j++)
            {
                System.out.print("*");
            }
            System.out.println("");
        }
    }
}