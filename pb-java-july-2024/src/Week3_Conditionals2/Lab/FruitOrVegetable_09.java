package Week3_Conditionals2.Lab;

import java.util.Scanner;

public class FruitOrVegetable_09
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        String a = scanner.nextLine();

        switch (a)
        {
            case "banana":
            case "apple":
            case "kiwi":
            case "cherry":
            case "lemon":
            case "grapes":
                System.out.println("fruit");
                break;
            case "tomato":
            case "cucumber":
            case "pepper":
            case "carrot":
                System.out.println("vegetable");
                break;
            default:
                System.out.println("unknown");
                break;
        }
    }
}
