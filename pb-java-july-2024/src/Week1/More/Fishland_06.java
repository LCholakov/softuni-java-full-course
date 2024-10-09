package Week1.More;

import java.util.Scanner;

public class Fishland_06
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        double atlanMackPrice = Double.parseDouble(scanner.nextLine());
        double spratPrice = Double.parseDouble(scanner.nextLine());
        double bonitoQty = Double.parseDouble(scanner.nextLine());
        double jackMackQty = Double.parseDouble(scanner.nextLine());
        double musselsQty = Double.parseDouble(scanner.nextLine());

        double bonitoPrice = bonitoQty * (atlanMackPrice * 1.6);
        double jackMackPrice = jackMackQty * (spratPrice * 1.8);
        double musselsPrice = musselsQty * 7.5;

        double result = bonitoPrice + jackMackPrice + musselsPrice;

        System.out.printf("%.2f", result);
    }
}
