package Week4_Methods.More;

import java.util.Scanner;

public class CenterPoint_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        printCloserPoint(Integer.parseInt(scanner.nextLine())
                        , Integer.parseInt(scanner.nextLine())
                        , Integer.parseInt(scanner.nextLine())
                        , Integer.parseInt(scanner.nextLine()));
    }

    private static void printCloserPoint(int x1, int y1, int x2, int y2) {
        if(x1*x1 + y1*y1 <= x2*x2 + y2*y2) {
            System.out.printf("(%d, %d)", x1, y1);
        } else {
            System.out.printf("(%d, %d)", x2, y2);
        }
    }
}
