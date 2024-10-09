package Week2_Conditionals1.More;

import java.util.Scanner;

public class PipesInPool_01
{
    public static void main(String[] args)
    {
        // inputs
        Scanner scanner = new Scanner(System.in);
        int v = Integer.parseInt(scanner.nextLine());
        int p1 = Integer.parseInt(scanner.nextLine());
        int p2 = Integer.parseInt(scanner.nextLine());
        double h = Double.parseDouble(scanner.nextLine());

        double water = p1 * h + p2 * h;
        double result = v - water;

        if (result >= 0)
        {
            double p1percent = 100.0 * p1 / (p1 + p2);  // int division chops off decimal, need conversion to double
            double p2percent = 100.0 * p2 / (p1 + p2);
            double fillPercent = 100.0 * water / v;
            System.out.printf("The pool is %.2f%% full. Pipe 1: %.2f%%. Pipe 2: %.2f%%.", fillPercent, p1percent, p2percent);
        }
        else
        {
            System.out.printf("For %.2f hours the pool overflows with %.2f liters.", h, Math.abs(result));
        }
    }
}
