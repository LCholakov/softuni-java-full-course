package Week1.More;

import java.util.Scanner;

public class WeatherForecast2_10
{
    public static void main(String[] args)
    {
        Scanner scanner  = new Scanner(System.in);

        double temp = scanner.nextDouble();

        if (26.0 <= temp && temp <= 35.0)
        {
            System.out.println("Hot");
        }
        else if (20.1 <= temp && temp <= 25.9)
        {
            System.out.println("Warm");
        }
        else if (15.0 <= temp && temp <= 20.0)
        {
            System.out.println("Mild");
        }
        else if (12.0 <= temp && temp <= 14.9)
        {
            System.out.println("Cool");
        }
        else if (5.0 <= 11.9 && temp <= 11.9)
        {
            System.out.println("Cold");
        }
        else
        {
            System.out.println("unknown");
        }
    }
}
