package Week1_BasicSyntaxReview.Exer;

import java.util.Scanner;

public class TriangleOfNumbers_08
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= n; i++)
        {
            for (int j = 0; j < i; j++)
            {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
