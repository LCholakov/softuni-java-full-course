package Week4_ForLoop.More;

import java.util.Scanner;

public class EqualPairs_08
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        boolean allEqual = true;
        int prevVal = 0;
        int currVal = 0;
        int maxDiff = 0;
        int n1 = 0;
        int n2 = 0;

        for (int i = 1; i <= n * 2; i++)
        {
            int x = Integer.parseInt(scanner.nextLine());
            prevVal = currVal;
            if ( i % 2 != 0)
            {
                n1 = x;
            }
            else
            {
                n2 = x;
                currVal = n1 + n2;
            }

            if (n == 1 || prevVal == currVal)
            {
                allEqual = true;
            }
            else
            {
                allEqual = false;
                maxDiff = Math.abs(prevVal - currVal);
            }
        }

        if(allEqual)
        {
            System.out.printf("Yes, value=%d", currVal);
        }
        else
        {
            System.out.printf("No, maxdiff=%d", maxDiff);
        }
    }
}
