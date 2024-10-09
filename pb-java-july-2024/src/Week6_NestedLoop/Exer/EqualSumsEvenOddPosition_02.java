package Week6_NestedLoop.Exer;

import java.util.Scanner;

public class EqualSumsEvenOddPosition_02
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        String n1 = scanner.nextLine();
        String n2 = scanner.nextLine();

        int sumOdd = 0;
        int sumEven = 0;
        int tempNum = 0;
        int d1 = 0;
        int d2 = 0;
        int d3 = 0;
        int d4 = 0;
        int d5 = 0;
        int d6 = 0;

        for (int i = Integer.parseInt(n1); i <= Integer.parseInt(n2); i++)
        {
            tempNum = i;
            d6 = tempNum % 10;
            tempNum /= 10;
            d5 = tempNum % 10;
            tempNum /= 10;
            d4 = tempNum % 10;
            tempNum /= 10;
            d3 = tempNum % 10;
            tempNum /= 10;
            d2 = tempNum % 10;
            tempNum /= 10;
            d1 = tempNum % 10;

            sumOdd = d1 + d3 + d5;
            sumEven = d2 + d4 + d6;

            if(sumOdd == sumEven)
                System.out.printf("%d ", i);
        }
    }
}
