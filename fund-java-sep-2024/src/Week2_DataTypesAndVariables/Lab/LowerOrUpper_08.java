package Week2_DataTypesAndVariables.Lab;

import java.util.Scanner;

public class LowerOrUpper_08
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        char c = scanner.nextLine().charAt(0);
        if(c < 97)
            System.out.println("upper-case");
        else
            System.out.println("lower-case");
    }
}
