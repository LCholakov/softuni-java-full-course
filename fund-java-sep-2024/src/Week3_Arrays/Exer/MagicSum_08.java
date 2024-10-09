package Week3_Arrays.Exer;

import java.util.Arrays;
import java.util.Scanner;

public class MagicSum_08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // input line -> int array
        int[] numsArr = Arrays
                        .stream(scanner.nextLine().split(" "))
                        .mapToInt(e -> Integer.parseInt(e)).toArray();

        // number to compare to
        int n = Integer.parseInt(scanner.nextLine());

        // string to collect all pairs
        String strAllNums = "";

        // loop to check the sum and record in a string
        // populate array only if unique pair (incl reversed)
        for (int i = 0; i < numsArr.length; i++) {
            if (numsArr.length < 2) { break; }
            for (int j = i+1; j < numsArr.length; j++) {
//                if(numsArr[i] + numsArr[j] == n)
//                    System.out.println(numsArr[i] + " " + numsArr[j]);
                if(numsArr[i] + numsArr[j] == n && !strAllNums.contains(numsArr[i] + " " + numsArr[j]) && !strAllNums.contains(numsArr[j] + " " + numsArr[i])) {
                    strAllNums = strAllNums + numsArr[i] + " " + numsArr[j] + "\n";
                }
            }
        }

        // print string with pairs
        System.out.println(strAllNums.replace(", ", "\n"));

        // string with all pairs split to a string array for printing
//        String resultArr[] = strAllNums.split(", ");
        // Print all pairs -- unneccessary since I can re
//        for (String s : resultArr) {
//            System.out.println(s);
//        }

        // just numbers, no strings.
        // Couldn't compare if they are unique, so used strings for storing and check if unique
//        int[] numsArr = Arrays
//                        .stream(scanner.nextLine().split(" "))
//                        .mapToInt(e -> Integer.parseInt(e)).toArray();
//        int n = Integer.parseInt(scanner.nextLine());
//
//        for (int i = 0; i < numsArr.length - 1; i++) {
//            for (int j = i; j < numsArr.length; j++) {
//                if (numsArr[i] + numsArr[j] == n)
//                    System.out.println(numsArr[i] + " " + numsArr[j]);
//            }
//        }
    }
}
