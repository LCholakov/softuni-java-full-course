package Week2_Conditionals1.More;

import java.util.Scanner;

public class FlowerShop_06
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        int magnoliaQty = Integer.parseInt(scanner.nextLine());
        int hyacinthQty = Integer.parseInt(scanner.nextLine());
        int roseQty = Integer.parseInt(scanner.nextLine());
        int cactusQty = Integer.parseInt(scanner.nextLine());
        double giftPrice = Double.parseDouble(scanner.nextLine());

        double magnoliaPrice = 3.25;
        double hyacinthPrice = 4.0;
        double rosePrice = 3.5;
        double cactusPrice = 8;

        double orderTotal = (magnoliaQty * magnoliaPrice
                            + hyacinthQty * hyacinthPrice
                            + roseQty * rosePrice
                            + cactusQty * cactusPrice)
                            * 0.95;      // subtract 5% tax

        double result = orderTotal - giftPrice;

        if (result >= 0 )
        {
            System.out.printf("She is left with %.0f leva.", Math.floor(result));
        }
        else
        {
            System.out.printf("She will have to borrow %.0f leva.", Math.ceil(Math.abs(result)));
        }

    }
}
