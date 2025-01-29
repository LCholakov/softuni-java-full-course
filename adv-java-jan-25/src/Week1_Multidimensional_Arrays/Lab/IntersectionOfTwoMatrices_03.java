package Week1_Multidimensional_Arrays.Lab;

import java.util.Scanner;

public class IntersectionOfTwoMatrices_03 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int rows = Integer.parseInt(scan.nextLine());
        int cols = Integer.parseInt(scan.nextLine());

        char [][] charArr_A = new char[rows][cols];
        char [][] charArr_B = new char[rows][cols];
        char [][] charArr_C = new char[rows][cols];

        for (int i = 0; i < rows; i++) {
            charArr_A[i] = scan.nextLine().replace(" ", "").toCharArray();
        }
        for (int i = 0; i < rows; i++) {
            charArr_B[i] = scan.nextLine().replace(" ", "").toCharArray();
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (charArr_A[i][j] == charArr_B[i][j]) {
                    System.out.print(charArr_A[i][j] + " ");
                } else {
                    System.out.print("* ");
                }
            }
            System.out.println();

        }
    }
}
