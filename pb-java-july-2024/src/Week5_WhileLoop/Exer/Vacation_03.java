package Week5_WhileLoop.Exer;

import java.util.Scanner;

public class Vacation_03
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        double minVacMoney = Double.parseDouble(scanner.nextLine());
        double savedMoney = Double.parseDouble(scanner.nextLine());

        int consecSpendCounter = 0;
        int dayCounter = 0;

        while (true)
        {
            String type = scanner.nextLine();
            double amount = Double.parseDouble(scanner.nextLine());
            if (type.equals("spend"))
            {
                ++consecSpendCounter;
                ++dayCounter;
                savedMoney -= amount;
                if (savedMoney < 0)
                {
                    savedMoney = 0;
                }
                if (consecSpendCounter == 5)
                {
                    System.out.printf("You can't save the money.%n%d", dayCounter);
                    break;
                }
            }

            if (type.equals("save"))
            {
                consecSpendCounter = 0;
                ++dayCounter;
                savedMoney += amount;
            }

            if (savedMoney >= minVacMoney)
            {
                System.out.printf("You saved the money for %d days.", dayCounter);
                break;
            }
        }
    }
}
