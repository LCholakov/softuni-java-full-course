package Week4_ForLoop.Lab;

import java.util.Scanner;

public class VowelsSum_06
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        String s = scanner.nextLine();
        int sum = 0;
        for (int i = 0; i < s.length(); ++i)
        {
            switch (s.charAt(i))
            {
                case 'a':
                    sum += 1;
                    break;
                case 'e':
                    sum += 2;
                    break;
                case 'i':
                    sum += 3;
                    break;
                case 'o':
                    sum += 4;
                    break;
                case 'u':
                    sum += 5;
                    break;
                default:
                    break;
            }
        }
        System.out.println(sum);
    }
}