package Week4_ForLoop.More;

import java.util.Scanner;

public class OddEvenPosition_11
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        double oddSum = 0.0;
        double oddMin = Integer.MAX_VALUE;
        double oddMax = Integer.MIN_VALUE;
        double evenSum = 0.0;
        double evenMin = Integer.MAX_VALUE;
        double evenMax = Integer.MIN_VALUE;

        for (int i = 1; i <= n; i++)
        {
            double x = Double.parseDouble(scanner.nextLine());
            if (i % 2 == 0)
            {
                evenSum += x;
                if (x > evenMax)
                    evenMax = x;
                if (x < evenMin)
                    evenMin = x;
            }
            else
            {
                oddSum += x;
                if (x > oddMax)
                    oddMax = x;
                if (x < oddMin)
                    oddMin = x;
            }
        }

        System.out.printf("OddSum=%.2f,%n", oddSum);
        if (n == 0)
        {
            System.out.println("OddMin=No,");
            System.out.println("OddMax=No,");
        }
        else
        {
            System.out.printf("OddMin=%.2f,%n", oddMin);
            System.out.printf("OddMax=%.2f,%n", oddMax);
        }
        System.out.printf("EvenSum=%.2f,%n", evenSum);
        if (n == 0 || n == 1)
        {
            System.out.println("EvenMin=No,");
            System.out.println("EvenMax=No");
        }
        else
        {
            System.out.printf("EvenMin=%.2f,%n", evenMin);
            System.out.printf("EvenMax=%.2f%n", evenMax);
        }
    }
}
