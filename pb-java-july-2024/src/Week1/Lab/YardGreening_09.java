package Week1.Lab;

import java.util.Scanner;

public class YardGreening_09
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Please enter the garden area: ");
        double gardenArea = Double.parseDouble(scanner.nextLine());
        double gardeningPrice = 7.61;
        double discountPercentage = 18.0;
        double totalPrice = (gardenArea * gardeningPrice) * (1-discountPercentage/100);
        double discountAmount = (gardenArea * gardeningPrice) * discountPercentage/100;

        System.out.printf("The final price is: %f lv.", totalPrice);
        System.out.printf("The discount is: %f lv.", discountAmount);
    }
}
