package Week3_Conditionals2.More;

import java.util.Scanner;

public class MultiplyBy2_10
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        double x = 0.0;

        while (x >= 0)
        {
            x = Double.parseDouble(scanner.nextLine());
            if (x >= 0)
                System.out.printf("Result: %.2f\n", 2 * x);
            else
                System.out.printf("Negative number!");
        }
    }
}