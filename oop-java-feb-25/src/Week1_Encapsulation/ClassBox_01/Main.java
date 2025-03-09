package Week1_Encapsulation.ClassBox_01;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Box box = new Box(Double.parseDouble(scan.nextLine())
                , Double.parseDouble(scan.nextLine())
                , Double.parseDouble(scan.nextLine()));


        System.out.printf("Surface Area - %.2f%n", box.calculateSurfaceArea());
        System.out.printf("Lateral Surface Area - %.2f%n", box.calculateLateralSurfaceArea());
        System.out.printf("Volume - %.2f%n", box.calculateVolume());
    }
}
