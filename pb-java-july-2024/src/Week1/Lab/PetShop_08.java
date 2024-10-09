package Week1.Lab;

import java.util.Scanner;

public class PetShop_08
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        int dogFoodCount = Integer.parseInt(scanner.nextLine());
        int catFoodCount = Integer.parseInt(scanner.nextLine());

        double totalAmount = dogFoodCount * 2.5 + catFoodCount * 4;

        System.out.printf("%f lv.", totalAmount);
    }
}
