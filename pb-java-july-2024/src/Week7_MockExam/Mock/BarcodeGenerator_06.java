package Week7_MockExam.Mock;

import java.util.Scanner;

public class BarcodeGenerator_06
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        int nBottom = Integer.parseInt(scanner.nextLine());
        int nTop = Integer.parseInt(scanner.nextLine());

        // Method 1 === correct answers for judge
        int d4bottom = nBottom % 10;
        nBottom /= 10;
        int d3bottom = nBottom % 10;
        nBottom /= 10;
        int d2bottom = nBottom % 10;
        nBottom /= 10;
        int d1bottom = nBottom;

        int d4top = nTop % 10;
        nTop /= 10;
        int d3top = nTop % 10;
        nTop /= 10;
        int d2top = nTop % 10;
        nTop /= 10;
        int d1top = nTop;

        for (int i = d1bottom; i <= d1top; i++)
        {
            if (i % 2 != 0)
                for (int j = d2bottom; j <= d2top; j++)
                {
                    if (j % 2 != 0)
                        for (int k = d3bottom; k <= d3top; k++)
                        {
                            if (k % 2 != 0)
                                for (int l = d4bottom; l <= d4top; l++)
                                {
                                    if (l % 2 != 0)
                                        System.out.printf("%d%d%d%d ", i, j, k, l);

                                }
                        }
                }
        }
    }
}
