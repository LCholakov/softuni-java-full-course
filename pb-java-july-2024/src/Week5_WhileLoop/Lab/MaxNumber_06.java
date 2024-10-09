package Week5_WhileLoop.Lab;

import java.util.Scanner;

public class MaxNumber_06
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        int n = 0;
        int max = Integer.MIN_VALUE;
        while (true)
        {
            String str = scanner.nextLine();
            if (str.equals("Stop"))
            {
                break;
            }
            n = Integer.parseInt(str);
            if (n > max)
                max = n;
        }

        System.out.println(max);
    }
}
