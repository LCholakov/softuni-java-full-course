package Week1.More;

import java.util.Scanner;

public class WeatherForecast1_09
{
    public static void main(String[] args)
    {
        Scanner scanner  = new Scanner(System.in);

        String str = scanner.nextLine();

        if (new String("sunny").equalsIgnoreCase(str))
        {
            System.out.println("It's warm outside!");
        }
        else
        {
            System.out.println("It's cold outside!");
        }
    }
}
