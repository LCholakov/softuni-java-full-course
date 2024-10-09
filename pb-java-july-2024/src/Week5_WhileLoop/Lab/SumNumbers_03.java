package Week5_WhileLoop.Lab;

import java.util.Scanner;

public class SumNumbers_03
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int sum = 0;

        while (sum < n)
        {
            sum += Integer.parseInt(scanner.nextLine());
        }

        System.out.println(sum);
    }
}
