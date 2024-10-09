package Week3_Conditionals2.Exer;

import java.util.Scanner;

public class Cinema_01
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        String type = scanner.nextLine();
        int rows = Integer.parseInt(scanner.nextLine());
        int columns = Integer.parseInt(scanner.nextLine());

        if (type.equals("Premiere"))
        {
            System.out.printf("%.2f leva", rows * columns * 12.0);
        }
        else if (type.equals("Normal"))
        {
            System.out.printf("%.2f leva", rows * columns * 7.5);
        }
        else if (type.equals("Discount"))
        {
            System.out.printf("%.2f leva", rows * columns * 5.0);
        }
    }
}