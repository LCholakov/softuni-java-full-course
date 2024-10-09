package Week5_WhileLoop.More;

import java.util.Scanner;

public class ReportSystem_02
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        int goal = Integer.parseInt(scanner.nextLine());
        String input = "";
        int amount = 0;
        int sumCash = 0;
        int countCash = 0;
        int sumCard = 0;
        int countCard = 0;
        int round = 0;

        while (goal > sumCard + sumCash)
        {
            input = scanner.nextLine();
            if (input.equals("End")) { break; }
            amount = Integer.parseInt(input);
            ++round;
            if (round % 2 == 0)
            {   // even round, card only, min 10
                if (amount < 10)
                {
                    System.out.println("Error in transaction!");
                }
                else
                {
                    ++countCard;
                    sumCard += amount;
                    System.out.println("Product sold!");
                }
            }
            else
            {   // odd round, cash only, max 100
                if (amount > 100)
                {
                    System.out.println("Error in transaction!");
                }
                else
                {
                    ++countCash;
                    sumCash += amount;
                    System.out.println("Product sold!");
                }
            }
        }

        if (goal <= sumCash + sumCard)
        {
            System.out.printf("Average CS: %.2f%n", 1.0 * sumCash / countCash);
            System.out.printf("Average CC: %.2f%n", 1.0 * sumCard / countCard);
        }
        else
        {
            System.out.println("Failed to collect required money for charity.");
        }
    }
}
