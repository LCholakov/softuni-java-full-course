package Week6_NestedLoop.More;

import java.util.Scanner;

public class UniquePINCodes_01
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        int d1max = Integer.parseInt(scanner.nextLine());
        int d2max = Integer.parseInt(scanner.nextLine());
        int d3max = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= d1max; i++)
        {
            // even only
            if (i % 2 == 0)
                for (int j = 2; j <= d2max; j++)
                {
                    // prime 2-7
                    if (j == 2 || j ==  3 || j == 5 || j == 7)
                        for (int k = 1; k <= d3max; k++)
                        {
                            // even only
                            if (k % 2 == 0)
                                System.out.printf("%d %d %d%n", i, j, k);
                        }
                }
        }
    }
}
