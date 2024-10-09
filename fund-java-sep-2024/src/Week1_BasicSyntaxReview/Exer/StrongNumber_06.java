package Week1_BasicSyntaxReview.Exer;

import java.util.Scanner;

public class StrongNumber_06
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int nTemp = n;
        int sum = 0;

        while (nTemp > 0) {
            int digit = nTemp % 10;
            nTemp /= 10;

            int digitFact = 1;
            for (int i = 2; i <= digit; i++)
            {
                digitFact *= i;
            }
            sum += digitFact;
        }

        if (sum == n)
            System.out.println("yes");
        else
            System.out.println("no");

    }
}
