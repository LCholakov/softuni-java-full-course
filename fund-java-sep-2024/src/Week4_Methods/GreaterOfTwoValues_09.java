package Week4_Methods;

import java.util.Scanner;

public class GreaterOfTwoValues_09 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        switch (scanner.nextLine()) {
            case "int" -> System.out.println(getMax(Integer.parseInt(scanner.nextLine()), Integer.parseInt(scanner.nextLine())));
            case "char" -> System.out.println(getMax(scanner.nextLine().charAt(0), scanner.nextLine().charAt(0)));
            case "string" -> System.out.println(getMax(scanner.nextLine(), scanner.nextLine()));
        }
    }

    private static int getMax(int n1, int n2) {
        return Math.max(n1, n2);
    }

    private static char getMax(char c1, char c2) {
        return (char) Math.max(c1, c2);
    }

    private static String getMax(String s1, String s2) {
        if (s1.compareTo(s2) > 0) {
            return s1;
        }
        return s2;
    }
}
