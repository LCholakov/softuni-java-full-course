package Week1.More;

import java.util.Scanner;

public class CelsiusToFahrenheit_03
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        double celsius = Double.parseDouble(scanner.nextLine());

        double fahrenheit = (celsius * 9 / 5) + 32;

        System.out.printf("%.2f", fahrenheit);
    }
}
