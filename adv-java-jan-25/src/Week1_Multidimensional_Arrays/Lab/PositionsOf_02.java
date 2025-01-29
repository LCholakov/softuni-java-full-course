package Week1_Multidimensional_Arrays.Lab;

import java.util.Arrays;
import java.util.Scanner;

public class PositionsOf_02 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int [][] num2dArr = new int[scan.nextInt()][scan.nextInt()];
        scan.nextLine();
        for (int i = 0; i < num2dArr.length; i++) {
            num2dArr[i] = Arrays.stream(scan.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
//            for (int j = 0; j < num2dArr[0].length; j++) {
//                num2dArr[i][j] = scan.nextInt();
//            }
        }

        int n = Integer.parseInt(scan.nextLine());
        boolean isFound = false;

        for (int i = 0; i < num2dArr.length; i++) {
            for (int j = 0; j < num2dArr[0].length; j++) {
                if (n == num2dArr[i][j]) {
                    System.out.println(i + " " + j);
                    isFound = true;
                }
            }
        }
        if (!isFound) {
            System.out.println("not found");
        }
    }
}
