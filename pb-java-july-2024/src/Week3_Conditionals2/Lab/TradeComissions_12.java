package Week3_Conditionals2.Lab;

import java.util.Scanner;

public class TradeComissions_12
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        String city = scanner.nextLine();
        double sales = Double.parseDouble(scanner.nextLine());

        if (city.equals("Sofia"))
        {
            if (0 <= sales && sales <= 500)
                System.out.printf("%.2f", sales * 0.05);
            else if (500 < sales && sales <= 1000)
                System.out.printf("%.2f", sales * 0.07);
            else if (1000 < sales && sales <= 10000)
                System.out.printf("%.2f", sales * 0.08);
            else if (sales > 10000)
                System.out.printf("%.2f", sales * 0.12);
            else
                System.out.println("error");
        }
        else if (city.equals("Plovdiv"))
        {
            if (0 <= sales && sales <= 500)
                System.out.printf("%.2f", sales * 0.055);
            else if (500 < sales && sales <= 1000)
                System.out.printf("%.2f", sales * 0.08);
            else if (1000 < sales && sales <= 10000)
                System.out.printf("%.2f", sales * 0.12);
            else if (sales > 10000)
                System.out.printf("%.2f", sales * 0.145);
            else
                System.out.println("error");
        }
        else if (city.equals("Varna"))
        {
            if (0 <= sales && sales <= 500)
                System.out.printf("%.2f", sales * 0.045);
            else if (500 < sales && sales <= 1000)
                System.out.printf("%.2f", sales * 0.075);
            else if (1000 < sales && sales <= 10000)
                System.out.printf("%.2f", sales * 0.10);
            else if (sales > 10000)
                System.out.printf("%.2f", sales * 0.13);
            else
                System.out.println("error");
        }
        else
        {
            System.out.println("error");
        }
    }
}
