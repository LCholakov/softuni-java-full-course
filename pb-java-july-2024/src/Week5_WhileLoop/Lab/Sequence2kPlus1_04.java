package Week5_WhileLoop.Lab;

import java.util.Scanner;

public class Sequence2kPlus1_04
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int last = 1;

        while (last <= n)
        {
            System.out.println(last);
            last = 2 * last + 1;
        }
    }
}
