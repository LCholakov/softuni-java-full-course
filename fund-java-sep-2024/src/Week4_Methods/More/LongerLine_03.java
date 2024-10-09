package Week4_Methods.More;

import java.util.Scanner;

public class LongerLine_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //  would be tidier with a tuple or array or diy class for xy points
        int p1x1 = Integer.parseInt(scanner.nextLine());
        int p1y1 = Integer.parseInt(scanner.nextLine());
        int p1x2 = Integer.parseInt(scanner.nextLine());
        int p1y2 = Integer.parseInt(scanner.nextLine());

        int p2x1 = Integer.parseInt(scanner.nextLine());
        int p2y1 = Integer.parseInt(scanner.nextLine());
        int p2x2 = Integer.parseInt(scanner.nextLine());
        int p2y2 = Integer.parseInt(scanner.nextLine());

        long dist1 = getDistBtw2Points(p1x1, p1y1
                                    , p1x2, p1y2);
        long dist2 = getDistBtw2Points(p2x1, p2y1
                                    , p2x2, p2y2);

        if (dist1 >= dist2) {
            printCloserPointFirst(p1x1, p1y1, p1x2, p1y2);
        } else {
            printCloserPointFirst(p2x1, p2y1, p2x2, p2y2);
        }
    }

    private static int getDistBtw2Points(int x1, int y1, int x2, int y2) {
        return getHypothenuseSquared(x1 - x2, y1 - y2);
    }

    private static int getHypothenuseSquared(int a, int b) {
        return a*a + b*b;
    }

    private static void printCloserPointFirst(int x1, int y1, int x2, int y2) {
        if(getHypothenuseSquared(x1, y1) <= getHypothenuseSquared(x2, y2)) {
            System.out.printf("(%d, %d)(%d, %d)", x1, y1, x2, y2);
        } else {
            System.out.printf("(%d, %d)(%d, %d)", x2, y2, x1, y1);
        }
    }
}
