package Week4_ForLoop.More;

import java.util.Scanner;

public class Logistics_03
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        int cargoCount = Integer.parseInt(scanner.nextLine());

        int totalPrice = 0;
        int vanTonPrice = 200;
        int truckTonPrice = 175;
        int trainTonPrice = 120;
        int vanPrice = 0;
        int truckPrice = 0;
        int trainPrice = 0;

        int totalWeight = 0;
        int vanWeight = 0;
        int truckWeight = 0;
        int trainWeight = 0;

        double avgPerCargo = 0.0;
        double vanPerc = 0.0;
        double truckPerc = 0.0;
        double trainPerc = 0.0;

        for (int i = 0; i < cargoCount; ++i)
        {
            int cargoWeight = Integer.parseInt(scanner.nextLine());
            totalWeight += cargoWeight;
            if (cargoWeight <= 3)
                vanWeight += cargoWeight;
            else if (cargoWeight <= 11)
                truckWeight += cargoWeight;
            else
                trainWeight += cargoWeight;
        }

        vanPrice = vanWeight * vanTonPrice;
        truckPrice = truckWeight * truckTonPrice;
        trainPrice = trainWeight * trainTonPrice;

        totalPrice = vanPrice + truckPrice + trainPrice;

        avgPerCargo = 1.0 * totalPrice / totalWeight;

        vanPerc = 100.0 * vanWeight / totalWeight;
        truckPerc = 100.0 * truckWeight  / totalWeight;
        trainPerc = 100.0 * trainWeight / totalWeight;

        System.out.printf("%.2f%n", avgPerCargo);
        System.out.printf("%.2f%%%n", vanPerc);
        System.out.printf("%.2f%%%n", truckPerc);
        System.out.printf("%.2f%%%n", trainPerc);
    }
}
