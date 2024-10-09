package Week6_NestedLoop.More;

import java.nio.file.LinkPermission;
import java.util.Scanner;

public class LettersCombinations_02
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        char start = scanner.nextLine().charAt(0);
        char end = scanner.nextLine().charAt(0);
        char skip = scanner.nextLine().charAt(0);
        int counter = 0;

        for (int i = start; i <= end; i++)
        {
            if (i == skip) { continue; }
            for (int j = start; j <= end; j++)
            {
                if (j == skip) { continue; }
                for (int k = start; k <= end; k++)
                {
                    if (k == skip) { continue; }
                    System.out.printf("%c%c%c ", i, j, k);
                    ++counter;
                }
            }
        }

        System.out.println(counter);
    }
}
