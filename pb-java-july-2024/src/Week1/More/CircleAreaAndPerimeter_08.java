package Week1.More;

import java.util.Scanner;

public class CircleAreaAndPerimeter_08
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        double r = Double.parseDouble(scanner.nextLine());

        double circumference = 2 * Math.PI * r;
        double area = Math.PI * r * r;

        System.out.printf("%.2f\n", area);
        System.out.printf("%.2f", circumference);
    }
}
