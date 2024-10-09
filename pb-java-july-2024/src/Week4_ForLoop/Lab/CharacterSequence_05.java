package Week4_ForLoop.Lab;

import java.util.Scanner;

public class CharacterSequence_05
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        String s = scanner.nextLine();
        int sum = 0;
        for (int i = 0; i < s.length(); ++i)
        {
            System.out.println(s.charAt(i));
        }

    }
}