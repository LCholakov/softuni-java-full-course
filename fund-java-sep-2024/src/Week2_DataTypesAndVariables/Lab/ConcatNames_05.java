package Week2_DataTypesAndVariables.Lab;

import java.util.Scanner;

public class ConcatNames_05
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        String name1 = scanner.nextLine();
        String name2 = scanner.nextLine();
        String delim = scanner.nextLine();

        System.out.println(name1 + delim + name2);
    }
}
