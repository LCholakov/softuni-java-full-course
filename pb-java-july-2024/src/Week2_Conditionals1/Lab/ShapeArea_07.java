package Week2_Conditionals1.Lab;

import java.util.Scanner;

public class ShapeArea_07
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        String shape = scanner.nextLine();

        if (shape.equals("square"))
        {
            double a = Double.parseDouble(scanner.nextLine());
            double result = a * a;
            System.out.printf("%.3f", result);
        }
        else if (shape.equals("rectangle"))
        {
            double a = Double.parseDouble(scanner.nextLine());
            double b = Double.parseDouble(scanner.nextLine());
            double result = a * b;
            System.out.printf("%.3f", result);
        }
        else if (shape.equals("circle"))
        {
            double r = Double.parseDouble(scanner.nextLine());
            double result = Math.PI * r * r;
            System.out.printf("%.3f", result);
        }
        else if (shape.equals("triangle"))
        {
            double a = Double.parseDouble(scanner.nextLine());
            double h = Double.parseDouble(scanner.nextLine());
            double result = (a * h) / 2;
            System.out.printf("%.3f", result);
        }
    }
}
