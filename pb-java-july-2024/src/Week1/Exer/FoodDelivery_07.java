package Week1.Exer;

import java.util.Scanner;

public class FoodDelivery_07
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        int numChickMenu = Integer.parseInt(scanner.nextLine());
        int numFishMenu = Integer.parseInt(scanner.nextLine());
        int numVeggieMenu = Integer.parseInt(scanner.nextLine());

        double priceChickMenu = 10.35;
        double priceFishMenu = 12.4;
        double priceVeggieMenu = 8.15;
        double dessertPercent = 20.0; // dessert price is 20% of the whole order excluding delivery
        double priceDelivery = 2.5;

        double priceAllMenus = numChickMenu * priceChickMenu
                + numFishMenu * priceFishMenu
                + numVeggieMenu * priceVeggieMenu;
        double priceWholeOrder = priceAllMenus * (1 + dessertPercent / 100) + priceDelivery;

        System.out.println(priceWholeOrder);
    }
}
