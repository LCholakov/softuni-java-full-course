package Week6_NestedLoop.More;

import java.util.Scanner;

public class SumOfTwoNumbers_09
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        int a = Integer.parseInt(scanner.nextLine());
        int b = Integer.parseInt(scanner.nextLine());
        int magicNum = Integer.parseInt(scanner.nextLine());
        int iterCounter = 0;
        boolean magicComboExists = false;

        for (int i = a; i <= b; ++i)
        {
            for (int j = a; j <= b; ++j)
            {
                ++iterCounter;
                if (i + j == magicNum)
                {
                    System.out.printf("Combination N:%d (%d + %d = %d)", iterCounter, i, j, magicNum);
                    magicComboExists = true;
                }
            }
            if (magicComboExists) { break; }
        }
        if (!magicComboExists)
        {
            System.out.printf("%d combinations - neither equals %d", iterCounter, magicNum);
        }
    }
}
