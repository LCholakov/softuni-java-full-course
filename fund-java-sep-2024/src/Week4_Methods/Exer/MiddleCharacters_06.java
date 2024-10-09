package Week4_Methods.Exer;

import java.util.Scanner;

public class MiddleCharacters_06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        printMiddleChar(scanner.nextLine());
    }

    private static void printMiddleChar(String s) {
        int len = s.length();
        if(len % 2 == 0) {
            // concat empty string to stringify, else int vals are printed
            System.out.print(s.charAt(len / 2 - 1) + "" + s.charAt(len / 2));

        } else {
            System.out.print(s.charAt(len / 2));
        }
    }
}
