package Week1_Multidimensional_Arrays.Exer;
import java.util.Scanner;
public class ReverseMatrixDiagonals_11 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String [] sizeInput = scan.nextLine().split("\\s+");
        int height = Integer.parseInt(sizeInput[0]);
        int width = Integer.parseInt(sizeInput[1]);
        int [][] nMtrx = new int[height][width];
        for (int i = 0; i < nMtrx.length; i++) {
            String [] rowInput = scan.nextLine().split("\\s+");
            for (int j = 0; j < nMtrx[0].length; j++) {
                nMtrx[i][j] = Integer.parseInt(rowInput[j]);
            }

        }

        // I couldn't solve it myself.
        // Found this algo in stackoverflow
        // https://stackoverflow.com/questions/1779199/traverse-matrix-in-diagonal-strips

        for (int diag = width + height - 2; diag >= 0; diag--) {
            int i_start = diag < width ? 0 : diag - width + 1;
            int i_end = diag < height ? diag + 1 : height;
            for (int i = i_end - 1; i >= i_start; --i)
            {
                System.out.print(nMtrx[i][diag - i] + " ");
            }
            System.out.println();
        }

        // indexes
        //
        // 0:0 0:1 0:2 0:3 0:4
        // 1:0 1:1 1:2 1:3 1:4
        // 2:0 2:1 2:2 2:3 2:4
        //
        // 2:3
        // 2:2 1:3
        // 2:1 1:2 0:3
        // 2:0 1:1 0:2
        // 1:0 0:1
        // 0:0
    }
}
