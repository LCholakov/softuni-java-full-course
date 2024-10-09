package Week1_BasicSyntaxReview.Exer;

import java.util.Scanner;

public class Ages_01
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        if (n < 0) {
            return;
        }
        if (n < 3)
            System.out.println("baby");
        else if (n < 14)
            System.out.println("child");
        else if (n < 20)
            System.out.println("teenager");
        else if (n < 66)
            System.out.println("adult");
        else
            System.out.println("elder");
    }
}
