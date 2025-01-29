package Week1_Multidimensional_Arrays.Lab;

import java.util.Scanner;

public class FindTheRealQueen_07 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int nRowsCols = 8;
//        while (true) {
            char[][] charArr = new char[nRowsCols][nRowsCols];

            for (int i = 0; i < nRowsCols; i++) {
                charArr[i] = scan.nextLine().replace(" ", "").toCharArray();
            }

            boolean breakLoops = false;
            for (int i = 0; i < nRowsCols; i++) {
                for (int j = 0; j < nRowsCols; j++) {
                    if (charArr[i][j] == 'q' && isValidPosition(charArr, i, j)) {
                        System.out.println(i + " " + j);
                        breakLoops = true;
                        break;
                    }
                }
                if (breakLoops) {
                    break;
                }
            }
//        }
    }

    private static boolean isValidPosition(char[][] charArr, int row, int col) {
        // is valid horizontally
        for (int i = 0; i < charArr.length; i++) {
            if (i != col && charArr[row][i] == 'q') {
                return false;
            }
        }
        // is valid vertically
        for (int i = 0; i < charArr.length; i++) {
            if (i != row && charArr[i][col] == 'q') {
                return false;
            }
        }
        // primary up left
        int i = row;
        int j = col;
        while (i > 0 && j > 0) {
            i--;
            j--;
            if (charArr[i][j] == 'q') {
                return false;
            }
        }
        // primary down right
        i = row;
        j = col;
        while (i < charArr.length - 1 && j < charArr.length - 1) {
            i++;
            j++;
            if (charArr[i][j] == 'q') {
                return false;
            }
        }
        // secondary up right
        i = row;
        j = col;
        while (i > 0 && j < charArr.length - 1) {
            i--;
            j++;
            if (charArr[i][j] == 'q') {
                return false;
            }
        }
        // secondary down left
        i = row;
        j = col;
        while (i < charArr.length - 1 && j > 0) {
            i++;
            j--;
            if (charArr[i][j] == 'q') {
                return false;
            }
        }
        return true;
    }
}

