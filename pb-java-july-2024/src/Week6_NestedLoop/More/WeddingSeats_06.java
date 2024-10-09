package Week6_NestedLoop.More;

import java.util.Scanner;

public class WeddingSeats_06
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);


        char endArea = scanner.nextLine().charAt(0);
        int firstAreaRowCount = Integer.parseInt(scanner.nextLine());
        int oddRowSeatCount = Integer.parseInt(scanner.nextLine());
        int currRowSeatCount = 0;
        int seatCount = 0;

        for (int i = 'A'; i <= endArea; i++)
        {
            for (int j = 1; j <= firstAreaRowCount + i - 'A'; j++)       // sketchy shit, trying to increment rows but char A is 65
            {
                if (j % 2 == 0)
                    currRowSeatCount = oddRowSeatCount + 2;
                else
                    currRowSeatCount = oddRowSeatCount;

                for (int k = 'a'; k < 'a' + currRowSeatCount; k++)
                {
                    System.out.printf("%c%d%c%n", i, j, k);
                    ++ seatCount;
                }
            }
        }
        System.out.println(seatCount);
    }
}
