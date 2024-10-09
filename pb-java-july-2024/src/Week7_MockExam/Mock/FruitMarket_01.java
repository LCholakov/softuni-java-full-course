package Week7_MockExam.Mock;

import java.util.Scanner;

public class FruitMarket_01
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        double strawberryPrice = Double.parseDouble(scanner.nextLine());
        double raspberryPrice = strawberryPrice * 0.5;
        double orangePrice = raspberryPrice * 0.6;
        double bananaPrice = raspberryPrice * 0.2;

        double bananaQty = Double.parseDouble(scanner.nextLine());
        double orangeQty = Double.parseDouble(scanner.nextLine());
        double raspberryQty = Double.parseDouble(scanner.nextLine());
        double strawberryQty = Double.parseDouble(scanner.nextLine());

        double result = strawberryQty * strawberryPrice
                        + bananaQty * bananaPrice
                        + orangeQty * orangePrice
                        + raspberryQty * raspberryPrice;
        System.out.printf("%.2f", result);
    }
}
