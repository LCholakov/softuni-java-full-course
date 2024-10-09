package Week6_NestedLoop.Lab;

import java.util.Scanner;

public class Building_06
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        int floorN = Integer.parseInt(scanner.nextLine());
        int roomN = Integer.parseInt(scanner.nextLine());

        for (int i = floorN; i > 0; --i)
        {
            for (int j = 0; j < roomN; j++)
            {
                if (i == floorN)
                    System.out.printf("L%d%d ", i, j);

                else if (i % 2 == 0)
                    System.out.printf("O%d%d ", i, j);

                else
                    System.out.printf("A%d%d ", i, j);
            }
            System.out.printf("%n");
        }
    }
}
