package Week6_NestedLoop.More;

import java.util.Scanner;

public class CarNumber_04
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        int start = Integer.parseInt(scanner.nextLine());
        int end = Integer.parseInt(scanner.nextLine());

        for (int i = start; i <= end; i++)
        {
            for (int j = start; j <= end; j++)
            {
                for (int k = start; k <= end; k++)
                {
                    for (int l = start; l <= end; l++)
                    {
                        if (i > l                       // first larger than last
                            && (j + k) % 2 == 0         // sum of digits 2 and 3 is even
                            && ((i % 2 == 0 && l % 2 != 0) || (i % 2 != 0 && l % 2 == 0)))  // first even + last odd or the vice-versa
                        {
                            System.out.printf("%d%d%d%d ", i, j, k, l);
                        }
                    }
                }
            }
        }
    }
}
