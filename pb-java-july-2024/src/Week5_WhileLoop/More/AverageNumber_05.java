package Week5_WhileLoop.More;

import java.util.Scanner;

public class AverageNumber_05
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        int sum = 0;
        int counter = 0;

        while (counter < n)
        {
            sum += Integer.parseInt(scanner.nextLine());
            ++counter;
        }

        System.out.printf("%.2f", 1.0 * sum / counter);
    }
}
