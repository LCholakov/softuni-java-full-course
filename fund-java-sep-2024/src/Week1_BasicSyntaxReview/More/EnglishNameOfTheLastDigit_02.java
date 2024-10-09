package Week1_BasicSyntaxReview.More;

import java.util.Scanner;

public class EnglishNameOfTheLastDigit_02
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        String result = switch (n % 10) {
            case 0 -> "zero";
            case 1 -> "one";
            case 2 -> "two";
            case 3 -> "three";
            case 4 -> "four";
            case 5 -> "five";
            case 6 -> "six";
            case 7 -> "seven";
            case 8 -> "eight";
            case 9 -> "nine";
            default -> "error";
        };
        System.out.println(result);
    }
}
