package Week2_DataTypesAndVariables.Lab;

import java.util.Scanner;

public class PoundsToDollars_02
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        float GBP = Float.parseFloat(scanner.nextLine());

        System.out.printf("%.3f", GBP * 1.36);
    }
}
