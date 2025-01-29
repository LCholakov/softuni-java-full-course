package Week1_Multidimensional_Arrays.Exer;

import java.util.Scanner;

public class MatrixOfPalindromes_02 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int rows = scan.nextInt();
        int cols = scan.nextInt();

        String [][] strMatr = new String[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                char c1 = (char)('a' + i);
                char c2 = (char)('a' + i + j);
                strMatr[i][j] = "" + c1 + c2 + c1 + " ";
                System.out.print(strMatr[i][j]);
            }
            System.out.println();
        }
    }
}
