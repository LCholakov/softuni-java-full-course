package Week2_Conditionals1.Lab;

import java.util.Scanner;

public class ExcellentResult_01
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        int input = Integer.parseInt(scanner.nextLine());

        if (input >= 5)
        {
            System.out.println("Excellent!");
        }
    }
}