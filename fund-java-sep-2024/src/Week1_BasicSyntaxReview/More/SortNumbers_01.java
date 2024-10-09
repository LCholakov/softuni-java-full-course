package Week1_BasicSyntaxReview.More;

import java.util.Scanner;

public class SortNumbers_01
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        int a = Integer.parseInt(scanner.nextLine());
        int b = Integer.parseInt(scanner.nextLine());
        int c = Integer.parseInt(scanner.nextLine());
        int temp;

        if (b < a ) {
            temp = a;
            a = b;
            b = temp;
        }

        if (c < b) {
            temp = b;
            b = c;
            c = temp;
            if (b < a ) {
                temp = a;
                a = b;
                b = temp;
            }
        }

        System.out.printf("%d%n%d%n%d%n", c, b, a);
    }
}
