package Week4_Methods.Exer;

import java.util.Scanner;

public class CharactersInRange_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        printCharsInRange(scanner.nextLine().charAt(0), scanner.nextLine().charAt(0));
    }

    private static void printCharsInRange(char c1, char c2) {
        for (int i = Math.min(c1, c2) + 1; i < Math.max(c1, c2); i++) {
            System.out.print((char)i + " ");
        }
    }
}
