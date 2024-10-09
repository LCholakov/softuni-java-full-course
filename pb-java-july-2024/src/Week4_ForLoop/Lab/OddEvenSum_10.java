package Week4_ForLoop.Lab;

import java.util.Scanner;

public class OddEvenSum_10
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int sumEven = 0;
        int sumOdd = 0;
        int result = 0;

        for (int i = 1; i <= n; ++i)
        {
            int n_i = Integer.parseInt(scanner.nextLine());
            if (i % 2 ==0)
            {
                sumEven += n_i;
            }
            else
            {
                sumOdd += n_i;
            }
        }

        result = sumEven - sumOdd;

        if (result == 0)
        {
            System.out.printf("Yes\nSum = %d", sumEven);
        }
        else
        {
            System.out.printf("No\nDiff = %d", Math.abs(result));
        }
    }
}