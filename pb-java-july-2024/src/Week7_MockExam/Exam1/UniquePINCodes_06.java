package Week7_MockExam.Exam1;

import java.util.Scanner;

public class UniquePINCodes_06
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        int d1Top = Integer.parseInt(scanner.nextLine());
        int d2Top = Integer.parseInt(scanner.nextLine());
        int d3Top = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= d1Top; i++)
        {
            if (i % 2 == 0)
                for (int j = 2; j <= d2Top; j++)
                {
                    if (j == 2 || j == 3 || j == 5 || j == 7)
                        for (int k = 1; k <= d3Top; k++)
                        {
                            if (k % 2 == 0)
                                System.out.printf("%d %d %d%n", i, j, k);
                        }

                }
        }
    }
}
