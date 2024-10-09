package Week1_BasicSyntaxReview.More;

import java.util.Scanner;

public class Messages_05
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        String output = "";

        int len = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < len; i++)
        {
            String s = scanner.nextLine();

            int d = Integer.parseInt(s) % 10;
            int n = s.length();
            if (d == 0) {
                output = output + " ";
                continue;
            }

            int offset = (d - 2) * 3;
            if (d > 7) {
                ++offset;
            }

            output = output + (char) (offset + n + 96);
        }
        System.out.println(output);
    }
}
