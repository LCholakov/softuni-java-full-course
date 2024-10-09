package Week2_DataTypesAndVariables.Lab;

import java.util.Scanner;

public class CharsToString_06
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        String output = "";

        for (int i = 0; i < 3; i++)
        {
            output = output + scanner.nextLine().charAt(0);
        }
        System.out.println(output);
    }
}
