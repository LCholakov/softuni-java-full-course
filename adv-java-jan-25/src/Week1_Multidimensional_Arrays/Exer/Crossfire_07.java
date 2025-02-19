package Week1_Multidimensional_Arrays.Exer;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Crossfire_07 {
    // Version 2
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String sizeStr = scan.nextLine();
        int sizeR = Integer.parseInt(sizeStr.split("\\s+")[0]);
        int sizeC = Integer.parseInt(sizeStr.split("\\s+")[1]);
        List<List<Integer>> listMatrix = new ArrayList<>();

        // populate matrix
        // running the .add on the whole matrix is apparently ridiculously slow and doesn't pass the time limit
        // needs a local currList var, and at the end assign the whole list to the matrix row
        int counter = 1;
        for (int i = 0; i < sizeR; i++) {
//            listMatrix.add(new ArrayList<>());
            List<Integer> currList = new ArrayList<>();
            for (int j = 0; j < sizeC; j++) {
//                listMatrix.get(i).add(counter);
                currList.add(counter);
                counter++;
            }
            listMatrix.add(currList);
        }

        // get input and destroy
        String cmd = scan.nextLine();
        while (!cmd.equals("Nuke it from orbit")) {
            String [] tokens = cmd.split("\\s+");
            int x = Integer.parseInt(tokens[0]);
            int y = Integer.parseInt(tokens[1]);
            int radius = Integer.parseInt(tokens[2]);

            // vertical except cross center
            for (int i = x - radius; i <= x + radius; i++) {
                if (isInBounds(i, y, listMatrix) && i != x) {
                    listMatrix.get(i).remove(y);
                }
            }

            // horizontal
            for (int i = y + radius; i >= y - radius; i--) {
                if (isInBounds(x, i, listMatrix)) {
                    listMatrix.get(x).remove(i);
                }
            }

            listMatrix.removeIf(List::isEmpty);
            cmd = scan.nextLine();
        }

        for (List<Integer> list : listMatrix) {
            for (int n : list) {
               System.out.print(n + " ");
            }
            System.out.println();
        }
    }

    private static boolean isInBounds(int x, int y, List<List<Integer>> listMatrix) {
        return x >= 0 && x < listMatrix.size()
                && y >= 0 && y < listMatrix.get(x).size();
    }


    // Version 1
//    public static void main(String[] args) {
//        Scanner scan = new Scanner(System.in);
//        String[] sizeStr = scan.nextLine().split("\\s+");
//        String[][] matrix = new String[Integer.parseInt(sizeStr[0])][Integer.parseInt(sizeStr[1])];
//
//        populateMatrix(matrix);
//
//        String[] cmd = scan.nextLine().split("\\s+");
//        while (!cmd[0].equals("Nuke")) {
//            int x = Integer.parseInt(cmd[0]);
//            int y = Integer.parseInt(cmd[1]);
//            int radius = Integer.parseInt(cmd[2]);
//
//            if (isInBounds(matrix, x, y)) {
//                nukeCross(matrix, x, y, radius);
//            } else {
//                continue;
//            }
//            cmd = scan.nextLine().split("\\s+");
//        }
//
//        printMatrix(matrix);
//
//        System.out.println();
//
//    }
//
//    private static boolean isInBounds(String[][] matrix, int x, int y) {
//        return x >= 0 && x < matrix.length
//                && y >= 0 && y < matrix[0].length;
//    }
//
//    private static void nukeCross(String[][] matrix, int x, int y, int radius) {
//
//        // vertical except center
//        for (int i = x - radius; i <= x + radius; i++) {
//            // row is in bounds
//            if (isInBounds(matrix, i, y) && i != x) {
//                // if last in row -> replace with space
//                if (y == matrix[0].length - 1) {
//                    matrix[i][y] = " ";
//                } else {        // if not last, shift values 1 cell to the right
//                    for (int j = y; j < matrix[0].length - 1; j++) {
//                        matrix[i][j] = matrix[i][j + 1];
//                    }
//                    // set last element to space
//                    matrix[i][matrix[0].length - 1] = " ";
//                }
//            }
//        }
//
//        // horizontal
//        // there is something to shift
//        if (y + radius < matrix[0].length - 1) {
//            int startIdx = Math.max(y - radius, 0);
//            // I'm tired, this is getting ugly and out of hand.
//            // I'm 100% sure it won't work.
//            // should have done an array of lists.
//            int counter = 0;
//
//            for (int i = y + radius + 1; i < matrix[0].length; i++) {
//                matrix[x][startIdx + counter] = matrix[x][i];
//                counter++;
//            }
//        } else {            //nothing to shift
//            for (int i = y - radius; i <= y + radius ; i++) {
//                if (isInBounds(matrix, x, i)) {
//                    matrix[x][i] = " ";
//                }
//            }
//        }
//    }
//
//    private static void populateMatrix(String[][] matrix) {
//        int counter = 1;
//        for (int i = 0; i < matrix.length; i++) {
//            for (int j = 0; j < matrix[0].length; j++) {
//                matrix[i][j] = counter++ + "";
//            }
//        }
//    }
//
//    private static void printMatrix(String[][] matrix) {
//        for (String[] sArr : matrix) {
//            for (String s : sArr) {
//                if (!s.equals("-")) {
//                    System.out.print(s + " ");
//                }
//            }
//            System.out.println();
//        }
//    }
}
