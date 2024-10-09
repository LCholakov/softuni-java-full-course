package Week2_Conditionals1.Exer;

import java.util.Scanner;

public class Shopping_07
{
    public static void main(String[] args)
    {
        // inputs
        Scanner scanner = new Scanner(System.in);
        double budget = Double.parseDouble(scanner.nextLine());
        int numGPU = Integer.parseInt(scanner.nextLine());
        int numCPU = Integer.parseInt(scanner.nextLine());
        int numRAM = Integer.parseInt(scanner.nextLine());

        double totalGPUprice = numGPU * 250;
        double totalCPUprice = numCPU * totalGPUprice * 0.35;
        double totalRAMprice = numRAM * totalGPUprice * 0.1;

        double totalOrderPrice = totalGPUprice + totalCPUprice + totalRAMprice;
        if (numGPU > numCPU)
        {
            totalOrderPrice *= 0.85;        // 15% off when more GPUs
        }

        double result = budget - totalOrderPrice;
        if (result > 0)
        {
            System.out.printf("You have %.2f leva left!", result);
        }
        else
        {
            System.out.printf("Not enough money! You need %.2f leva more!", Math.abs(result));
        }
    }
}
