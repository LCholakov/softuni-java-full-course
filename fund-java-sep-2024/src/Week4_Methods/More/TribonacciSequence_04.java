package Week4_Methods.More;

import java.util.Scanner;

public class TribonacciSequence_04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long [] tribArr = new long[Integer.parseInt(scanner.nextLine())];
        for (int i = 0; i < tribArr.length; i++) {
            if (i < 2) {
                tribArr[i] = 1;
            } else if (i == 2) {
                tribArr[i] = 2;
            } else {
                tribArr[i] = tribArr[i-1]
                            + tribArr[i-2]
                            + tribArr[i-3];
            }
            System.out.print(tribArr[i] + " ");
        }

//        printTribSequence(Integer.parseInt(scanner.nextLine()));
    }

//    private static void printTribSequence(int n) {
//        // add 3 to i range so that printed sequence starts with 1, instead of 0 0
//        for (int i = 3; i < n + 3; i++) {
//            System.out.print(getTribNum(i) + " ");
//        }
//    }
//
//    private static long getTribNum(int n) {
//        if (n < 3) {
//            return 0;
//        }
//        if (n == 3) {
//            return 1;
//        }
//        return getTribNum(n - 1)
//                + getTribNum(n - 2)
//                + getTribNum(n - 3);
//    }
}
