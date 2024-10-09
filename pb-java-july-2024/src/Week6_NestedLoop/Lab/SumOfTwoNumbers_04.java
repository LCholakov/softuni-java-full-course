package Week6_NestedLoop.Lab;

import java.util.Scanner;

public class SumOfTwoNumbers_04
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        int nLow = Integer.parseInt(scanner.nextLine());
        int nHigh = Integer.parseInt(scanner.nextLine());
        int magicNum = Integer.parseInt(scanner.nextLine());
        boolean comboExists = false;
        int counter = 0;
        int x = 0;
        int y = 0;

        for (int i = nLow; i <= nHigh; i++)
        {
            for (int j = nLow; j <= nHigh; j++)
            {
                ++counter;
                if (i + j == magicNum)
                {
                    comboExists = true;
                    x = i;
                    y = j;
                    break;
                }
            }
            if (comboExists)
                break;
        }

        if (comboExists)
            System.out.printf("Combination N:%d (%d + %d = %d)", counter, x, y, magicNum);
        else
            System.out.printf("%d combinations - neither equals %d", counter, magicNum);
    }
}
