package Week6_NestedLoop.Exer;

import java.util.Scanner;

public class SpecialNumbers_05
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int tempIndex;
        int digit = 0;

        for (int i = 1111; i <= 9999; i++)
        {
            boolean isMagical = true;
            tempIndex = i;

            for (int j = 0; j < 4 ; j++)
            {
                digit = tempIndex % 10;
                tempIndex /= 10;
                if (digit == 0 || n % digit != 0)
                {
                    isMagical = false;
                    break;
                }
            }

            if (isMagical)
                System.out.printf("%d ", i);
        }
    }
}
