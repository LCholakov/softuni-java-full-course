package Week3_Conditionals2.Exer;

import java.util.Scanner;

public class FishingBoat_04
{
    public static void main(String[] args)
    {
        // inputs
        Scanner scanner = new Scanner(System.in);
        int budget = Integer.parseInt(scanner.nextLine());
        String season = scanner.nextLine();
        int headCount = Integer.parseInt(scanner.nextLine());

        // globals
        double totalPrice = 0.0;
        double result = 0.0;

        // set season price
        switch (season)
        {
            case "Spring":
                totalPrice = 3000.0;
                break;
            case "Summer":
            case "Autumn":
                totalPrice = 4200.0;
                break;
            case "Winter":
                totalPrice = 2600.0;
                break;
            default:
                break;
        }

        // set base discounts
        if (headCount <= 6)
            totalPrice *= 0.9;
        else if (7 <= headCount && headCount <= 11)
            totalPrice *= 0.85;
        else if (headCount >= 12)
            totalPrice *= 0.75;

        // set special discount for even num of ppl
        if (headCount % 2 == 0 && !season.equals("Autumn"))
        {
            totalPrice *= 0.95;
        }

        // output

        result = budget - totalPrice;
        if (result >= 0)
        {
            System.out.printf("Yes! You have %.2f leva left.", result);
        }
        else
        {
            System.out.printf("Not enough money! You need %.2f leva.", Math.abs(result));
        }
    }
}