package Week6_NestedLoop.More;

import java.util.Scanner;

public class SafePasswordsGenerator_07
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        int a = Integer.parseInt(scanner.nextLine());
        int b = Integer.parseInt(scanner.nextLine());
        int maxPwdCount = Integer.parseInt(scanner.nextLine());
        int pwdCounter = 0;
        boolean maxPwdReached = false;
        int d1 = 35;
        int d2 = 64;

        for (int i = 1; i <= a; i++)
        {
            for (int j = 1; j <= b; j++)
            {
                System.out.printf("%c%c%d%d%c%c|", d1, d2, i, j, d2, d1);

                ++d1;
                ++d2;
                if (d1 > 55) { d1 = 35; }
                if (d2 > 96) { d2 = 64; }

                ++pwdCounter;
                if (pwdCounter == maxPwdCount)
                {
                    maxPwdReached = true;
                    break;
                }
            }
            if (maxPwdReached) { break; }
        }
    }
}
