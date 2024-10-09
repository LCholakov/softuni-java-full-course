package Week1_BasicSyntaxReview.Exer;

import java.util.Scanner;

public class PadawanEquipment_10
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        double budget = Double.parseDouble(scanner.nextLine());
        int headCount = Integer.parseInt(scanner.nextLine());
        double saberPrice = Double.parseDouble(scanner.nextLine());
        double robePrice = Double.parseDouble(scanner.nextLine());
        double beltPrice = Double.parseDouble(scanner.nextLine());

        double totalPrice = Math.ceil(headCount * 1.1) * saberPrice
                            + headCount * robePrice
                            + (headCount - headCount / 6) * beltPrice;

        double result = budget - totalPrice;

        if (result < 0) {
            System.out.printf("George Lucas will need %.2flv more.", Math.abs(result));
        }
        else {
            System.out.printf("The money is enough - it would cost %.2flv.", totalPrice);
        }
    }
}
