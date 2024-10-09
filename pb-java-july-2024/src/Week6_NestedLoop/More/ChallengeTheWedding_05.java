package Week6_NestedLoop.More;

import java.util.Scanner;

public class ChallengeTheWedding_05
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        int nMen = Integer.parseInt(scanner.nextLine());
        int nWomen = Integer.parseInt(scanner.nextLine());
        int nTables = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= nMen; i++)
        {
            for (int j = 1; j <= nWomen; j++)
            {
                System.out.printf("(%d <-> %d) ", i, j);
                --nTables;
                if (nTables == 0) { break; }
            }
            if (nTables == 0) { break; }
        }
    }
}
