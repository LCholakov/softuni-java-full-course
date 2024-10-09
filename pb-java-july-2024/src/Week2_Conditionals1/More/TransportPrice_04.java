package Week2_Conditionals1.More;

import java.util.Scanner;

public class TransportPrice_04
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        int dist = Integer.parseInt(scanner.nextLine());
        String time = scanner.nextLine();

        double taxiInitialPrice = 0.7;
        double taxiDayPrice = 0.79;
        double taxiNightPrice = 0.90;
        double busPrice = 0.09;
        double trainPrice = 0.06;

        double result = -1;

        if (dist < 20)
        {
            if (time.equals("day"))
            {
                result = taxiInitialPrice + dist * taxiDayPrice;
                System.out.printf("%.2f", result);
            }
            else if (time.equals("night"))
            {
                result = taxiInitialPrice + dist * taxiNightPrice;
                System.out.printf("%.2f", result);
            }
        }
        else if (dist < 100)
        {
            result = dist * busPrice;
            System.out.printf("%.2f", result);
        }
        else
        {
            result = dist * trainPrice;
            System.out.printf("%.2f", result);
        }
    }
}
