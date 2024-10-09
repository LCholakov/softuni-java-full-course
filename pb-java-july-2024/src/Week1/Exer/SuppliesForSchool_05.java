package Week1.Exer;

import java.util.Scanner;

public class SuppliesForSchool_05
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        int numPenSets = Integer.parseInt(scanner.nextLine());
        int numMarkerSets = Integer.parseInt(scanner.nextLine());
        int whBoardLiquid = Integer.parseInt(scanner.nextLine());
        int discountRate = Integer.parseInt(scanner.nextLine());

        double pricePenSet = 5.8;
        double priceMarkerSet = 7.2;
        double priceWhBoardLiquid = 1.2;

        double totalAmount = (numPenSets * pricePenSet
                            + numMarkerSets * priceMarkerSet
                            + whBoardLiquid * priceWhBoardLiquid)
                            * (1 - discountRate / 100.0);

        System.out.println(totalAmount);
    }
}
