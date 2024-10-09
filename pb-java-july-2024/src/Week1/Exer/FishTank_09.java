package Week1.Exer;

import java.util.Scanner;

public class FishTank_09
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        int length = Integer.parseInt(scanner.nextLine());
        int width = Integer.parseInt(scanner.nextLine());
        int height = Integer.parseInt(scanner.nextLine());
        double equipmentVolumePercent = Double.parseDouble(scanner.nextLine());

        double absoluteVolume = length * width * height / 1000.0; // volume in litres from measurements in cm
        double waterVolume = absoluteVolume * (1 - equipmentVolumePercent / 100);

        System.out.println(waterVolume);
    }
}
