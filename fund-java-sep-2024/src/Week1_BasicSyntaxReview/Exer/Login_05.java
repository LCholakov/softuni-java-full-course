package Week1_BasicSyntaxReview.Exer;

import java.util.Scanner;

public class Login_05
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        String usr = scanner.nextLine();
        String pwd = "";

        for (int i = usr.length() - 1; i >= 0 ; i--)
        {
            pwd += usr.charAt(i);
        }

        for (int i = 1; i <= 4; i++)
        {
            String s = scanner.nextLine();
            if (s.equals(pwd))
            {
                System.out.printf("User %s logged in.", usr);
                break;
            }
            if (i == 4) {
                System.out.printf("User %s blocked!", usr);
            }
            else {
                System.out.println("Incorrect password. Try again.");
            }




        }
    }
}
