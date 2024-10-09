package Week1.More;

import java.util.Scanner;

public class HousePainting_07
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        double x = Double.parseDouble(scanner.nextLine());
        double y = Double.parseDouble(scanner.nextLine());
        double h = Double.parseDouble(scanner.nextLine());

        double grnCoverage = 3.4;       // coverage sqm / L
        double redCoverage = 4.3;       // coverage sqm / L
        // Walls:
        // 2 square walls side x
        // 2 rect walls sides x & y
        // 2 square windows 1.5, 1 door 1.2x2
        // Roof:
        // 2 rect x & y
        // 2 isosceles triangles side x & height h

        double wallArea = 2 * (x * x)  + 2 * ( x * y) - 1.2 * 2 - 2 * (1.5 * 1.5);
        double roofArea = 2 * (x * y) + x * h;

        double grnPaintQty = wallArea / grnCoverage;
        double redPaintQty = roofArea / redCoverage;

        System.out.printf("%.2f\n", grnPaintQty);
        System.out.printf("%.2f", redPaintQty);
    }
}

