package Week3_Conditionals2.Lab;
import java.util.Scanner;

public class SmallShop_05
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        String product = scanner.nextLine();
        String city = scanner.nextLine();
        double qty = Double.parseDouble(scanner.nextLine());

        double result = 0;
        if (city.equals("Sofia"))
        {
            switch (product)
            {
                case "coffee":
                    result = qty * 0.5;
                    break;
                case "water":
                    result = qty * 0.8;
                    break;
                case "beer":
                    result = qty * 1.2;
                    break;
                case "sweets":
                    result = qty * 1.45;
                    break;
                case "peanuts":
                    result = qty * 1.6;
                    break;
                default:
                    System.out.println("Error");
                    break;
            }
        }
        else if (city.equals("Plovdiv"))
        {
            switch (product)
            {
                case "coffee":
                    result = qty * 0.4;
                    break;
                case "water":
                    result = qty * 0.7;
                    break;
                case "beer":
                    result = qty * 1.15;
                    break;
                case "sweets":
                    result = qty * 1.3;
                    break;
                case "peanuts":
                    result = qty * 1.5;
                    break;
                default:
                    System.out.println("Error");
                    break;
            }
        }
        else if (city.equals("Varna"))
        {
            switch (product)
            {
                case "coffee":
                    result = qty * 0.45;
                    break;
                case "water":
                    result = qty * 0.7;
                    break;
                case "beer":
                    result = qty * 1.1;
                    break;
                case "sweets":
                    result = qty * 1.35;
                    break;
                case "peanuts":
                    result = qty * 1.55;
                    break;
                default:
                    System.out.println("Error");
                    break;
            }
        }
        System.out.println(result);
    }
}