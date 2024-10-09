package Week1.Exer;

import java.util.Scanner;

public class BasketballEquipment_08
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        int yearlyFee = Integer.parseInt(scanner.nextLine());

        double sneakerPrice = yearlyFee * 0.6;
        double clothesPrice = sneakerPrice * 0.8;
        double ballPrice = clothesPrice / 4.0;
        double accessoriesPrice = ballPrice / 5.0;

        double totalAmount = yearlyFee
                            + sneakerPrice
                            + clothesPrice
                            + ballPrice
                            + accessoriesPrice;

        System.out.println(totalAmount);
    }
}
