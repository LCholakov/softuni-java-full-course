package Week1_Multidimensional_Arrays.Exer;

import java.util.Arrays;
import java.util.Scanner;

public class MatrixShuffling_05 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int [] size = Arrays.stream(scan.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        String [][] strMatr = new String[size[0]][size[1]];

        for (int i = 0; i < size[0]; i++) {
            strMatr[i] = scan.nextLine().split("\\s+");
        }
        while (true) {
            String [] cmd = scan.nextLine().split("\\s+");
            if (cmd[0].equals("END")) { break; }

            // check for invalid input
            String invalidMsg = "Invalid input!";
            if (!cmd[0].equals("swap")
                || cmd.length != 5) {
                System.out.println(invalidMsg);
                continue;
            }
            int r1 = Integer.parseInt(cmd[1]);
            int c1 = Integer.parseInt(cmd[2]);
            int r2 = Integer.parseInt(cmd[3]);
            int c2 = Integer.parseInt(cmd[4]);

            if (r1 < 0 || c1 < 0 || r2 < 0 || c2 < 0) {
                System.out.println(invalidMsg);
                continue;
            }
            if (r1 >= size[0] || r2 >= size[0] || c1 >= size[1] || c2 >= size[1]) {
                System.out.println(invalidMsg);
                continue;
            }

            String sTemp = strMatr[r1][c1];
            strMatr[r1][c1] = strMatr[r2][c2];
            strMatr[r2][c2] = sTemp;

            for (int i = 0; i < size[0]; i++) {
                Arrays.stream(strMatr[i]).forEach(s -> System.out.print(s + " "));
                System.out.println();
            }
        }
    }
}
