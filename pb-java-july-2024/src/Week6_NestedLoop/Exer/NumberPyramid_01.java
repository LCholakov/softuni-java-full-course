package Week6_NestedLoop.Exer;

import java.util.Scanner;

public class NumberPyramid_01
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        int output = 1;
        for (int i = 1; i <= n; ++i)
        {
            for (int j = 1; j <= i; j++)
            {
                System.out.printf("%d ", output);
                ++output;
                if (output > n) { break; }
            }
            System.out.println();
            if (output > n) { break; }
        }
    }
}
