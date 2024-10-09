package Week3_Conditionals2.Exer;

import java.util.Scanner;

public class NewHouse_03
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        String flower = scanner.nextLine();
        int qty = Integer.parseInt(scanner.nextLine());
        int budget = Integer.parseInt(scanner.nextLine());

        double rosePrice = 5.0;
        double dahliaPrice = 3.8;
        double tulipPrice = 2.8;
        double narcissusPrice = 3.0;
        double gladiolusPrice = 2.5;

        double totalPrice = 0.0;

        if (flower.equals("Roses"))
        {
            totalPrice = qty * rosePrice;
            if (qty > 80) { totalPrice *= 0.9; }
        }
        else if (flower.equals("Dahlias"))
        {
            totalPrice = qty * dahliaPrice;
            if (qty > 90) { totalPrice *= 0.85; }
        }
        else if (flower.equals("Tulips"))
        {
            totalPrice = qty * tulipPrice;
            if (qty > 80) { totalPrice *= 0.85; }
        }
        else if (flower.equals("Narcissus"))
        {
            totalPrice = qty * narcissusPrice;
            if (qty < 120) { totalPrice *= 1.15; }
        }
        else if (flower.equals("Gladiolus"))
        {
            totalPrice = qty * gladiolusPrice;
            if (qty < 80) { totalPrice *= 1.2; }
        }

        double result = budget - totalPrice;
        if (result >= 0 )
        {
            System.out.printf("Hey, you have a great garden with %d %s and %.2f leva left.", qty, flower, result);
        }
        else
        {
            System.out.printf("Not enough money, you need %.2f leva more.", Math.abs(result));
        }
    }
}