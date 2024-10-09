package Week6_NestedLoop.More;

import java.util.Scanner;

public class TheSongOfTheWheels_12
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        int m = Integer.parseInt(scanner.nextLine());

        int hitCounter = 0;
        int fourthHit = -1;

        for (int a = 1; a <= 9; a++)
        {
            for (int b = 1; b <= 9; b++)
            {
                for (int c = 1; c <= 9; c++)
                {
                    for (int d = 1; d <= 9; d++)
                    {
                        if (a < b && c > d && (a * b) + (c * d) == m)
                        {
                            System.out.printf("%d%d%d%d ", a, b, c, d);
                            ++hitCounter;
                            if (hitCounter == 4)
                                fourthHit = a * 1000 + b * 100 + c * 10 + d;
                        }
                    }
                }
            }
        }

        if (fourthHit == -1 && hitCounter > 0)
            System.out.println("");

        if (fourthHit == -1)
            System.out.printf("No!");
        else
            System.out.printf("%nPassword: %d", fourthHit);
    }
}
