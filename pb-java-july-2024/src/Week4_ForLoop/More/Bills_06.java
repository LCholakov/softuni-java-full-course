package Week4_ForLoop.More;

import java.util.Scanner;

public class Bills_06
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        double powerBillsTotal = 0.0;
        double waterBillsTotal = n * 20;
        double internetBillsTotal = n * 15;
        double otherBillsTotal = 0.0;
        double averageMonthlyBill = 0.0;

        for (int i = 0; i < n; i++)
        {
            double powerBill = Double.parseDouble(scanner.nextLine());

            powerBillsTotal += powerBill;
            otherBillsTotal += (powerBill + 20 + 15) * 1.2;
        }

        averageMonthlyBill = (powerBillsTotal + waterBillsTotal + internetBillsTotal + otherBillsTotal) / n;

        System.out.printf("Electricity: %.2f lv%n", powerBillsTotal);
        System.out.printf("Water: %.2f lv%n", waterBillsTotal);
        System.out.printf("Internet: %.2f lv%n", internetBillsTotal);
        System.out.printf("Other: %.2f lv%n", otherBillsTotal);
        System.out.printf("Average: %.2f lv%n", averageMonthlyBill);
    }
}
