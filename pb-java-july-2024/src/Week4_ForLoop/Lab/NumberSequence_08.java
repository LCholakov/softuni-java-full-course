package Week4_ForLoop.Lab;

import java.util.Scanner;

public class NumberSequence_08
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int max = -2147483648;
        int min = 2147483647;

        for (int i = 1; i <= n; ++i)
        {
            int n_i = Integer.parseInt(scanner.nextLine());
            if (n_i < min) { min = n_i; }
            if (n_i > max) { max = n_i; }
        }

        System.out.printf("Max number: %d\n", max);
        System.out.printf("Min number: %d", min);
    }
}