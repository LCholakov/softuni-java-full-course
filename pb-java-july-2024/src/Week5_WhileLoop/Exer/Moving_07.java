package Week5_WhileLoop.Exer;

import java.util.Scanner;

public class Moving_07
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        int w = Integer.parseInt(scanner.nextLine());
        int l = Integer.parseInt(scanner.nextLine());
        int h = Integer.parseInt(scanner.nextLine());

        int totalVol = w * l * h;
        int boxSum = 0;

        while (boxSum < totalVol)
        {
            String str = scanner.nextLine();

            if (str.equals("Done"))
                break;

            boxSum += Integer.parseInt(str);
        }

        if (boxSum >= totalVol)
            System.out.printf("No more free space! You need %d Cubic meters more.", boxSum - totalVol);
        else
            System.out.printf("%d Cubic meters left.", totalVol - boxSum);

    }
}
