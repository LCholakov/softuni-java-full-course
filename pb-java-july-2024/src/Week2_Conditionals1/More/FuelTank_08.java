package Week2_Conditionals1.More;

import java.util.Scanner;

public class FuelTank_08
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        String fuelType = scanner.nextLine();
        double fuelQty = Double.parseDouble(scanner.nextLine());
        String clubCardStr = scanner.nextLine();

        double gasolinePrice = 2.22;
        double dieselPrice = 2.33;
        double gasPrice    = 0.93;

        double gasolineClubDiscount = 0.18;
        double dieselClubDiscount = 0.12;
        double gasClubDiscount    = 0.08;

        double totalAmount = 0.0;

        if (fuelType.equals("Gasoline"))
        {
            totalAmount = fuelQty * gasolinePrice;
            if (clubCardStr.equals("Yes"))
            {
                totalAmount -= fuelQty * gasolineClubDiscount;
            }
        }
        else if (fuelType.equals("Diesel"))
        {
            totalAmount = fuelQty * dieselPrice;
            if (clubCardStr.equals("Yes"))
            {
                totalAmount -= fuelQty * dieselClubDiscount;
            }
        }
        else if (fuelType.equals("Gas"))
        {
            totalAmount = fuelQty * gasPrice;
            if (clubCardStr.equals("Yes"))
            {
                totalAmount -= fuelQty * gasClubDiscount;
            }
        }

        if (fuelQty > 25)
        {
            totalAmount *= 0.9;
        }
        else if(fuelQty >= 20)
        {
            totalAmount *= 0.92;
        }

        System.out.printf("%.2f lv.", totalAmount);
    }
}
