package Week2_Conditionals1.Lab;

import java.util.Scanner;

public class PasswordGuess_04
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        String a = scanner.nextLine();
        String pwd = "s3cr3t!P@ssw0rd";
        if (a.equals(pwd))
        {
            System.out.println("Welcome");
        }
        else
        {
            System.out.println("Wrong password!");
        }
    }
}

