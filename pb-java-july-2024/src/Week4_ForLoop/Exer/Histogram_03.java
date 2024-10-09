package Week4_ForLoop.Exer;

import java.util.Scanner;

public class Histogram_03
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        double p1 = 0.0;
        double p2 = 0.0;
        double p3 = 0.0;
        double p4 = 0.0;
        double p5 = 0.0;

        int count_below199 = 0;
        int count_200to399 = 0;
        int count_400to599 = 0;
        int count_600to799 = 0;
        int count_above800 = 0;

        for (int i = 1; i <= n; ++i)
        {
            int n_i = Integer.parseInt(scanner.nextLine());

            if (1 <= n_i && n_i <= 199)
                ++count_below199;
            else if (200 <= n_i && n_i <= 399)
                ++count_200to399;
            else if (400 <= n_i && n_i <= 599)
                ++count_400to599;
            else if (600 <= n_i && n_i <= 799)
                ++count_600to799;
            else if (n_i >= 800)
                ++count_above800;
        }

        p1 = 100.0 * count_below199 / n;
        p2 = 100.0 * count_200to399 / n;
        p3 = 100.0 * count_400to599 / n;
        p4 = 100.0 * count_600to799 / n;
        p5 = 100.0 * count_above800 / n;

        System.out.printf("%.2f%%\n", p1);
        System.out.printf("%.2f%%\n", p2);
        System.out.printf("%.2f%%\n", p3);
        System.out.printf("%.2f%%\n", p4);
        System.out.printf("%.2f%%\n", p5);
    }
}
