package Week7_MockExam.Exam1;

import java.util.Scanner;

public class ExcursionSale_05
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        int nSeaTrip = Integer.parseInt(scanner.nextLine());
        int nMtnTrip = Integer.parseInt(scanner.nextLine());
        String input = scanner.nextLine();
        int profit = 0;

        while (!input.equals("Stop"))
        {
            if (input.equals("sea") && nSeaTrip > 0)
            {
                --nSeaTrip;
                profit += 680;
            }
            else if (input.equals("mountain") && nMtnTrip > 0)
            {
                --nMtnTrip;
                profit += 499;
            }

            if (nSeaTrip == 0 && nMtnTrip == 0)
            {
                System.out.println("Good job! Everything is sold.");
                break;
            }
            input = scanner.nextLine();
        }

        System.out.printf("Profit: %d leva.", profit);
    }
}
