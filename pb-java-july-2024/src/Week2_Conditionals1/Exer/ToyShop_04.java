package Week2_Conditionals1.Exer;

import java.util.Scanner;

public class ToyShop_04
{
    public static void main(String[] args)
    {
        // constants
        double puzzlePrice = 2.6;
        double dollPrice = 3.0;
        double teddyPrice = 4.1;
        double minionPrice = 8.2;
        double truckPrice = 2.0;
//        double rentMultiplier = 0.1;        // 10% of revenue
//        double discountMultiplier = 0.25;
        int discountThreshold = 50;            // 25% off when over 50 toys

        // inputs
        Scanner scanner = new Scanner(System.in);
        double  tripPrice = Double.parseDouble(scanner.nextLine());
        int     puzzleQty = Integer.parseInt(scanner.nextLine());
        int     dollQty = Integer.parseInt(scanner.nextLine());
        int     teddyQty = Integer.parseInt(scanner.nextLine());
        int     minionQty = Integer.parseInt(scanner.nextLine());
        int     truckQty = Integer.parseInt(scanner.nextLine());

        // calculations
        int sumToys = puzzleQty + dollQty + teddyQty + minionQty + truckQty;
        double sumPrice = puzzleQty * puzzlePrice
                            + dollQty * dollPrice
                            + teddyQty * teddyPrice
                            + minionQty * minionPrice
                            + truckQty * truckPrice;

        if (sumToys >= 50)
        {
            sumPrice *= 0.75;
        }
        double incomeAfterRent = sumPrice * 0.9;

        if (incomeAfterRent >= tripPrice)
        {
            System.out.printf("Yes! %.2f lv left.", (incomeAfterRent - tripPrice));
        }
        else
        {
            System.out.printf("Not enough money! %.2f lv needed.", (tripPrice - incomeAfterRent));
        }
    }
}
