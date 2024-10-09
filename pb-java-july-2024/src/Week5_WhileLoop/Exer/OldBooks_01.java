package Week5_WhileLoop.Exer;

import java.util.Scanner;

public class OldBooks_01
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        String searchBookTitle = scanner.nextLine();

        int counter = 0;

        while (true)
        {
            String currBook = scanner.nextLine();

            if (currBook.equals("No Week6_NestedLoop.More Books"))
            {
                System.out.println("The book you search is not here!");
                System.out.printf("You checked %d books.", counter);
                break;
            }
            if (currBook.equals(searchBookTitle))
            {
                System.out.printf("You checked %d books and found it.", counter);
                break;
            }

            ++counter;
        }
    }
}
