package Week1.More;

import java.util.Scanner;

public class TrainingLab_05
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        int xMeters = new Double(Double.parseDouble(scanner.nextLine()) * 100).intValue();
        int yMeters = new Double(Double.parseDouble(scanner.nextLine()) * 100).intValue();

        int numDeskX = xMeters / 120;
        int numDeskY = (yMeters - 100) / 70;           // subtract corridor and convert to cm

        int result = numDeskX * numDeskY - 3;              // multiply rows * columns and subtract door (1) and stand (2)

        System.out.println(result);
    }
}
