package Week6_NestedLoop.More;

import java.util.Scanner;

public class PrimePairs_13
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        int pair1bottom = Integer.parseInt(scanner.nextLine());
        int pair2bottom = Integer.parseInt(scanner.nextLine());
        int pair1top = pair1bottom + Integer.parseInt(scanner.nextLine());
        int pair2top = pair2bottom + Integer.parseInt(scanner.nextLine());


        for (int pair1 = pair1bottom; pair1 <= pair1top; pair1++)
        {
            boolean pair1isPrime = true;
            for (int i = 2; i < pair1; i++)
            {
                if (pair1 % i == 0)
                {
                    pair1isPrime = false;
                    break;
                }
            }

            if (pair1isPrime)
            {
                for (int pair2 = pair2bottom; pair2 <= pair2top; pair2++)
                {
                    boolean pair2isPrime = true;
                    for (int i = 2; i < pair2; i++)
                    {
                        if (pair2 % i == 0)
                        {
                            pair2isPrime = false;
                            break;
                        }

                    }

                    if(pair1isPrime && pair2isPrime)
                        System.out.printf("%d%d%n", pair1, pair2);
                }
            }
        }

    }
}
