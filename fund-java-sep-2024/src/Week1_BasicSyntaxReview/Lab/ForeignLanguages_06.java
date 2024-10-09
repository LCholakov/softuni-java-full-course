package Week1_BasicSyntaxReview.Lab;

import java.util.Scanner;

public class ForeignLanguages_06
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        String s = scanner.nextLine();
        String output = "";
        if (s.equals("USA") || s.equals("England"))
            output = "English";
        else if (s.equals("Spain") || s.equals("Argentina") || s.equals("Mexico"))
            output = "Spanish";
        else
            output = "unknown";

        System.out.println(output);
    }
}
