package Week1_BasicSyntaxReview.More;

import java.util.Scanner;

public class ReverseString_04
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        String s = scanner.nextLine();

        for (int i = s.length() - 1; i >= 0 ; i--)
        {
            System.out.print(s.charAt(i));
        }
    }
}
