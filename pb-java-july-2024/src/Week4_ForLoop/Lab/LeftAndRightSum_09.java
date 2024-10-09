package Week4_ForLoop.Lab;

import java.util.Scanner;

public class LeftAndRightSum_09
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int sumL = 0;
        int sumR = 0;
        int result = 0;

        for (int i = 1; i <= n; ++i)
        {
            int n_i = Integer.parseInt(scanner.nextLine());
            sumL += n_i;
        }
        for (int i = 1; i <= n; ++i)
        {
            int n_i = Integer.parseInt(scanner.nextLine());
            sumR += n_i;
        }

        result = sumL - sumR;

        if (result == 0)
        {
            System.out.printf("Yes, sum = %d", sumL);
        }
        else
        {
            System.out.printf("No, diff = %d", Math.abs(result));
        }
    }
}