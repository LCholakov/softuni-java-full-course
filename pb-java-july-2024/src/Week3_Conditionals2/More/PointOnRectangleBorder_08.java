package Week3_Conditionals2.More;

import java.util.Scanner;

public class PointOnRectangleBorder_08
{
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        double x1 = Double.parseDouble(scanner.nextLine());
        double y1 = Double.parseDouble(scanner.nextLine());
        double x2 = Double.parseDouble(scanner.nextLine());
        double y2 = Double.parseDouble(scanner.nextLine());
        double x = Double.parseDouble(scanner.nextLine());
        double y = Double.parseDouble(scanner.nextLine());

        String insideOutside = "Inside / Outside";
        String border = "Border";

        // if xy lies on top or bottom
        if ((y == y1 || y == y2) && (x1 <= x && x <= x2))
        {
            System.out.printf("%s", border);
        }
        // if xy lies on left or right
        else if ((x == x1 || x == x2) && (y1 <= y && y <= y2))
        {
            System.out.printf("%s", border);
        }
        else
        {
            System.out.printf("%s", insideOutside);
        }
    }
}