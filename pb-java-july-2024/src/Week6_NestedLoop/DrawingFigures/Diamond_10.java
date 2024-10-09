package Week6_NestedLoop.DrawingFigures;

import java.util.Scanner;

public class Diamond_10
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        int padLR = (n - 1) / 2;
        for (int i = 0; i < ((n - 1) / 2) * 2 + 1/*n*//*(n + 1) / 2*/; i++)
        {
            String lineOut = "";
            if ((n % 2 != 0 && i > n / 2) || (n % 2 == 0 && i >= n / 2))
                ++padLR;
            else if (i != 0)
                --padLR;

            int padMid = n - 2 * padLR - 2;

            for (int j = 0; j < padLR; j++)
            {
                lineOut += "-";
            }
            lineOut += "*";
            if (padMid >= 0)
            {
                for (int j = 0; j < padMid; j++)
                {
                    lineOut += "-";
                }
                lineOut += "*";
            }

            for (int j = 0; j < padLR; j++)
            {
                lineOut += "-";
            }
            System.out.println(lineOut);
        }
    }
}
