package Week1.More;

import java.util.Scanner;

public class VegetableMarket_04
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        double veggiePrice = Double.parseDouble(scanner.nextLine());
        double fruitPrice = Double.parseDouble(scanner.nextLine());
        int veggieAmount = Integer.parseInt(scanner.nextLine());
        int fruitAmount = Integer.parseInt(scanner.nextLine());
        double BGNEURrate = 1.94;

        double result = (veggieAmount * veggiePrice + fruitAmount * fruitPrice) / BGNEURrate;

        System.out.printf("%.2f", result);
    }
}
