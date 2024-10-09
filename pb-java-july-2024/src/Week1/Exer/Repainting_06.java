package Week1.Exer;

import java.util.Scanner;

public class Repainting_06
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        int plasticSheetSqM = Integer.parseInt(scanner.nextLine());
        int paintLitres = Integer.parseInt(scanner.nextLine());
        int thinnerLitres = Integer.parseInt(scanner.nextLine());
        int manHours = Integer.parseInt(scanner.nextLine());

        double pricePlasticSheet = 1.5;
        double pricePaint = 14.5;
        double priceThinner = 5.0;

        double totalPriceMaterials = (plasticSheetSqM + 2) * pricePlasticSheet
                                    + (paintLitres * 1.1) * pricePaint
                                    + thinnerLitres * priceThinner
                                    + 0.4;
        double totalPriceLabour = manHours * (totalPriceMaterials * 0.3);

        System.out.println(totalPriceMaterials + totalPriceLabour);
    }
}
