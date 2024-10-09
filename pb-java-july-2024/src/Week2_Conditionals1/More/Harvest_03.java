package Week2_Conditionals1.More;

import java.util.Scanner;

public class Harvest_03
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        int vineArea = Integer.parseInt(scanner.nextLine());            // sqm
        double grapeHarvest = Double.parseDouble(scanner.nextLine());     // kg / sqm
        int wineTargetQty = Integer.parseInt(scanner.nextLine());       // liters
        int numWorkers = Integer.parseInt(scanner.nextLine());

        double wineQty = (vineArea * grapeHarvest * 0.4) / 2.5;               // liters

        double result = 1.0 * wineTargetQty - wineQty;

        if (result > 0)
        {
            System.out.printf("It will be a tough winter! Week3.Week4.Week5_WhileLoop.Week6_NestedLoop.More %.0f liters wine needed.", Math.floor(result));
        }
        else
        {
            System.out.printf("Good harvest this year! Total wine: %.0f liters.\n", Math.floor(wineQty));
            System.out.printf("%.0f liters left -> %.0f liters per person.", Math.ceil(Math.abs(result)), Math.ceil(Math.abs(result) / numWorkers));
        }
    }
}