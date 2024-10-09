package Week5_WhileLoop.Lab;

import java.util.Scanner;

public class ReadText_01
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);


        while (true)
        {
            String str = scanner.nextLine();
            if(str.equals("Stop"))
                 break;
            else
                System.out.println(str);
        }
    }
}
