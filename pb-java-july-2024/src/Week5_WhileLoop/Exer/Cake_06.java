package Week5_WhileLoop.Exer;

import java.util.Scanner;

public class Cake_06
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        int w = Integer.parseInt(scanner.nextLine());
        int h = Integer.parseInt(scanner.nextLine());

        int area = w * h;
        int pcsSum = 0;

        while (pcsSum < area)
        {
            String str = scanner.nextLine();

            if (str.equals("STOP"))
                 break;

            pcsSum += Integer.parseInt(str);
        }

        if (pcsSum >= area)
            System.out.printf("No more cake left! You need %d pieces more.", pcsSum - area);
        else
            System.out.printf("%d pieces are left.", area - pcsSum);
    }
}
