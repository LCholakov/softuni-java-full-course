package Week5_WhileLoop.More;

import java.util.Scanner;

public class SteamOfLetters_03
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        char c = 'c';
        char o = 'o';
        char n = 'n';
        int cCount = 0;
        int oCount = 0;
        int nCount = 0;
        String wordTemp = "";
        String wordFinal = "";
        String input = "";
        char letter;

        while (true)
        {
            input = scanner.nextLine();
            if (input.equals("End")) { break; }

            letter = input.charAt(0);
            if (letter < 65 || (90 < letter && letter < 97) || letter > 122) { continue; }

            if (letter == c)
            {
                if (cCount != 0)
                    wordTemp += letter;
                ++cCount;
            }
            else if (letter == o)
            {
                if (oCount != 0)
                    wordTemp += letter;
                ++oCount;
            }
            else if (letter == n)
            {
                if (nCount != 0)
                    wordTemp += letter;
                ++nCount;
            }
            else
            {
                wordTemp += letter;
            }

            if (cCount != 0 && oCount != 0 && nCount != 0)
            {
                wordFinal += wordTemp + " ";
                wordTemp = "";
                cCount = 0;
                oCount = 0;
                nCount = 0;
            }
        }
        System.out.println(wordFinal);
    }
}
