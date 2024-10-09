package Week6_NestedLoop.Lab;

import java.util.Scanner;

public class Combinations_03
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int counter = 0;

        for (int i = 0; i <= n; i++)
        {
            for (int j = 0; j <= n - i; j++)
            {
                for (int k = 0; k <= n - j; k++)
                {
                    if (i + j + k == n)
                        ++counter;
                }
            }
        }

        System.out.println(counter);
    }
}

