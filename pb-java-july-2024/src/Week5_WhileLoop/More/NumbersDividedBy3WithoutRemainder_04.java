package Week5_WhileLoop.More;

import java.util.Scanner;

public class NumbersDividedBy3WithoutRemainder_04
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        for (int i = 3; i < 100; i += 3)
        {
            System.out.println(i);
        }
    }
}
