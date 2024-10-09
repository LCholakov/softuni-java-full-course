package Week4_ForLoop.More;

import java.util.Scanner;

public class GameOfIntervals_05
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        double score = 0.0;
        int count0to9 = 0;
        int count10to19 = 0;
        int count20to29 = 0;
        int count30to39 = 0;
        int count40to50 = 0;
        int countInvalid  = 0;
        for (int i = 0; i < n; ++i)
        {
            int n_i = Integer.parseInt(scanner.nextLine());

            if (n_i < 0 || n_i > 50)
            {
                ++countInvalid;
                score /= 2;
            }
            else if (n_i < 10)
            {
                ++count0to9;
                score += n_i * 0.2;
            }
            else if (n_i < 20)
            {
                ++count10to19;
                score += n_i * 0.3;
            }
            else if (n_i < 30)
            {
                ++count20to29;
                score += n_i * 0.4;
            }
            else if (n_i < 40)
            {
                ++count30to39;
                score += 50;
            }
            else
            {
                ++count40to50;
                score += 100;
            }
        }

        double perc0to9 = 100.0 * count0to9 / n;
        double perc10to19 = 100.0 * count10to19 / n;
        double perc20to29 = 100.0 * count20to29 / n;
        double perc30to39 = 100.0 * count30to39 / n;
        double perc40to50 = 100.0 * count40to50 / n;
        double percInvalid = 100.0 * countInvalid / n;

        System.out.printf("%.2f%n", score);
        System.out.printf("From 0 to 9: %.2f%%%n", perc0to9);
        System.out.printf("From 10 to 19: %.2f%%%n", perc10to19);
        System.out.printf("From 20 to 29: %.2f%%%n", perc20to29);
        System.out.printf("From 30 to 39: %.2f%%%n", perc30to39);
        System.out.printf("From 40 to 50: %.2f%%%n", perc40to50);
        System.out.printf("Invalid numbers: %.2f%%%n", percInvalid);
    }
}
