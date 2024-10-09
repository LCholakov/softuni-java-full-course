package Week3_Conditionals2.Exer;

import java.util.Scanner;

public class SummerOutfit_02
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        int temp = Integer.parseInt(scanner.nextLine());
        String tod = scanner.nextLine();

        if (tod.equals("Morning"))
        {
            if(10 <= temp && temp <= 18)
                System.out.printf("It's %d degrees, get your Sweatshirt and Sneakers.", temp);
            else if(18 < temp && temp <= 24)
                System.out.printf("It's %d degrees, get your Shirt and Moccasins.", temp);
            else if(temp >= 25)
                System.out.printf("It's %d degrees, get your T-Shirt and Sandals.", temp);
        }
        else if (tod.equals("Afternoon"))
        {
            if(10 <= temp && temp <= 18)
                System.out.printf("It's %d degrees, get your Shirt and Moccasins.", temp);
            else if(18 < temp && temp <= 24)
                System.out.printf("It's %d degrees, get your T-Shirt and Sandals.", temp);
            else if(temp >= 25)
                System.out.printf("It's %d degrees, get your Swim Suit and Barefoot.", temp);
        }
        else if (tod.equals("Evening"))
        {
            System.out.printf("It's %d degrees, get your Shirt and Moccasins.", temp);
        }
    }
}