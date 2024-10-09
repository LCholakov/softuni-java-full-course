package Week4_ForLoop.Exer;

import java.util.Scanner;

public class HalfSumElement_02
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int max = Integer.MIN_VALUE;
        int sum = 0;
        int result = 0;
        for (int i = 0; i < n; ++i)
        {
            int n_i = Integer.parseInt(scanner.nextLine());
            if (n_i >= sum || n_i > max)
            {
                max = n_i;
            }
            sum += n_i;
        }

        sum -= max;     // subtrct number we compare to from the sum

        result = sum - max;
        if (result == 0)
        {
            System.out.printf("Yes%nSum = %d", sum);
        }
        else
        {
            System.out.printf("No%nDiff = %d", Math.abs(result));
        }
    }
}
