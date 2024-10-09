package Week5_WhileLoop.Lab;

import java.util.Scanner;

public class MinNumber_07
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        int n = 0;
        int min = Integer.MAX_VALUE;
        while (true)
        {
            String str = scanner.nextLine();
            if (str.equals("Stop"))
            {
                break;
            }
            n = Integer.parseInt(str);
            if (n < min)
                min = n;
        }

        System.out.println(min);
    }
}
