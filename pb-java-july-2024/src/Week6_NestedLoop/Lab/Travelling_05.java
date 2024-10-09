package Week6_NestedLoop.Lab;

import java.util.Scanner;

public class Travelling_05
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        String destination = "";
        double minBudget = 0.0;
        double savedAmount = 0.0;

        while (true)
        {
            destination = scanner.nextLine();
            if (destination.equals("End")) { break; }
            minBudget = Double.parseDouble(scanner.nextLine());

            while (true)
            {
                savedAmount += Double.parseDouble(scanner.nextLine());

                if (savedAmount >= minBudget)
                {
                    System.out.printf("Going to %s!%n", destination);
                    savedAmount = 0.0;
                    break;
                }
            }
        }
    }
}
