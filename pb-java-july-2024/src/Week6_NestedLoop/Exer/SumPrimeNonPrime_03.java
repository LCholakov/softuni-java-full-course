package Week6_NestedLoop.Exer;

import java.util.Scanner;

public class SumPrimeNonPrime_03
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        String input = "";
        int n = 0;
        int sumPrime = 0;
        int sumNonprime = 0;

        while (true)
        {
            input = scanner.nextLine();

            if (input.equals("stop")) { break; }

            n = Integer.parseInt(input);
            if (n < 0)
            {
                System.out.println("Number is negative.");
                continue;
            }

            // declare in local scope to avoid resetting
            boolean isPrime = true;
            for (int i = 2; i < n; i++)
            {
                if (i != n && n % i == 0)
                {
                    isPrime = false;
                    break;
                }
            }

            if (isPrime)
                sumPrime += n;
            else
                sumNonprime += n;
        }

        System.out.println("Sum of all prime numbers is: " + sumPrime);
        System.out.println("Sum of all non prime numbers is: " + sumNonprime);
    }
}
