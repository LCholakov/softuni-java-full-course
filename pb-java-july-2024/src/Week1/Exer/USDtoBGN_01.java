package Week1.Exer;

import java.util.Scanner;

public class USDtoBGN_01
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        double amountUSD = Double.parseDouble(scanner.nextLine());

        double USD2BGNrate = 1.79549;

        System.out.println(amountUSD * USD2BGNrate);
    }
}
