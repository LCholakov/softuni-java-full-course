package Week3_Conditionals2.More;

import java.util.Scanner;

public class Flowers_03
{
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int chrysanthCount = Integer.parseInt(scanner.nextLine());
        int roseCount = Integer.parseInt(scanner.nextLine());
        int tulipCount = Integer.parseInt(scanner.nextLine());
        String season = scanner.nextLine();
        String isHoliday = scanner.nextLine();

        double chrysanthPrice = 0.0;
        double rosePrice = 0.0;
        double tulipPrice = 0.0;

        if (season.equals("Spring") || season.equals("Summer"))
        {
            chrysanthPrice = 2.0;
            rosePrice = 4.1;
            tulipPrice = 2.5;
        }
        else if (season.equals("Autumn") || season.equals("Winter"))
        {
            chrysanthPrice = 3.75;
            rosePrice = 4.5;
            tulipPrice = 4.15;
        }

        double totalPrice = chrysanthCount * chrysanthPrice + roseCount * rosePrice + tulipCount * tulipPrice;

        if (isHoliday.equals("Y"))
        {
            totalPrice *= 1.15;
        }
        if (tulipCount > 7 && season.equals("Spring"))
        {
            totalPrice *= 0.95;
        }
        if (roseCount >= 10 && season.equals("Winter"))
        {
            totalPrice *= 0.9;
        }
        if (chrysanthCount + roseCount + tulipCount > 20)
        {
            totalPrice *= 0.8;
        }

        // add flower arrangement
        totalPrice += 2.0;

        System.out.printf("%.2f", totalPrice);
    }
}