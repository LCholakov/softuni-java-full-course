package Week3_Conditionals2.Lab;

import java.util.Scanner;

public class FruitShop_11
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        String fruit = scanner.nextLine();
        String dow = scanner.nextLine();
        double qty = Double.parseDouble(scanner.nextLine());

        if (dow.equals("Monday") || dow.equals("Tuesday") || dow.equals("Wednesday") || dow.equals("Thursday") || dow.equals("Friday"))
        {
            switch (fruit)
            {
                case "banana":
                    System.out.printf("%.2f", qty * 2.5);
                    break;
                case "apple":
                    System.out.printf("%.2f", qty * 1.2);
                    break;
                case "orange":
                    System.out.printf("%.2f", qty * 0.85);
                    break;
                case "grapefruit":
                    System.out.printf("%.2f", qty * 1.45);
                    break;
                case "kiwi":
                    System.out.printf("%.2f", qty * 2.7);
                    break;
                case "pineapple":
                    System.out.printf("%.2f", qty * 5.5);
                    break;
                case "grapes":
                    System.out.printf("%.2f", qty * 3.85);
                    break;
                default:
                    System.out.println("error");
                    break;
            }
        }
        else if (dow.equals("Saturday") || dow.equals("Sunday"))
        {
            switch (fruit)
            {
                case "banana":
                    System.out.printf("%.2f", qty * 2.7);
                    break;
                case "apple":
                    System.out.printf("%.2f", qty * 1.25);
                    break;
                case "orange":
                    System.out.printf("%.2f", qty * 0.9);
                    break;
                case "grapefruit":
                    System.out.printf("%.2f", qty * 1.6);
                    break;
                case "kiwi":
                    System.out.printf("%.2f", qty * 3.0);
                    break;
                case "pineapple":
                    System.out.printf("%.2f", qty * 5.6);
                    break;
                case "grapes":
                    System.out.printf("%.2f", qty * 4.2);
                    break;
                default:
                    System.out.println("error");
                    break;
            }
        }
        else
        {
            System.out.println("error");
        }
    }
}
