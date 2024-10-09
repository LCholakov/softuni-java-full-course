package Week3_Conditionals2.Exer;

import java.util.Scanner;

public class OperationsBetweenNumbers_06
{
    public static void main(String[] args)
    {
        // inputs
        Scanner scanner = new Scanner(System.in);
        int n1 = Integer.parseInt(scanner.nextLine());
        int n2 = Integer.parseInt(scanner.nextLine());
        String oper = scanner.nextLine();

        double result = 0.0;
        String oddeven = "even";

        if (oper.equals("+"))
        {
            result = n1 + n2;
            if (result % 2 != 0) oddeven = "odd";
            System.out.printf("%d %s %d = %.0f - %s", n1, oper, n2, result, oddeven);
        }
        else if (oper.equals("-"))
        {
            result = n1 - n2;
            if (result % 2 != 0) oddeven = "odd";
            System.out.printf("%d %s %d = %.0f - %s", n1, oper,  n2, result, oddeven);
        }
        else if (oper.equals("*"))
        {
            result = n1 * n2;
            if (result % 2 != 0) oddeven = "odd";
            System.out.printf("%d %s %d = %.0f - %s", n1, oper,  n2, result, oddeven);
        }
        else if (oper.equals("/"))
        {
            if (n2 == 0) { System.out.printf("Cannot divide %d by zero", n1); }
            else
            {
                result = 1.0 * n1 / n2;
                System.out.printf("%d %s %d = %.2f", n1, oper,  n2, result);
            }
        }
        else if (oper.equals("%"))
        {
            if (n2 == 0) { System.out.printf("Cannot divide %d by zero", n1); }
            else
            {
                result = n1 % n2;
                System.out.printf("%d %s %d = %.0f", n1, oper,  n2, result);
            }
        }
    }
}