package Week4_Methods.Lab;

import java.util.Scanner;

public class RepeatString_07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(repeatStr(scanner.nextLine(), Integer.parseInt(scanner.nextLine())));
    }

    private static String repeatStr(String s, int n) {
        String result = s;
        for (int i = 1; i < n; i++) {
            result = result + s;
        }
        return result;
    }
}
