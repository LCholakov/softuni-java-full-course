package Week2_Conditionals1.Exer;

import java.util.Scanner;

public class GodzillaVsKong_05
{
    public static void main(String[] args)
    {

        // inputs
        Scanner scanner = new Scanner(System.in);
        double budget = Double.parseDouble(scanner.nextLine());
        int numExtras = Integer.parseInt(scanner.nextLine());
        double clothesPrice = Double.parseDouble(scanner.nextLine());

//        double decorPrice = budget * 0.1;
        double totalClothesPrice = numExtras * clothesPrice;
        if (numExtras > 150)
        {
            totalClothesPrice *= 0.9;
        }

        double result = budget * 0.9 - totalClothesPrice;  // 10% of budget go to decor

        if ( result < 0)
        {
            System.out.println("Not enough money!");
            System.out.printf("Wingard needs %.2f leva more.", Math.abs(result));
        }
        else
        {
            System.out.println("Action!");
            System.out.printf("Wingard starts filming with %.2f leva left.", result);
        }
    }
}
