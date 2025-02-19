package Week3_Functional_Programming.Exer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.BiPredicate;
import java.util.function.Predicate;

public class ListOfPredicates_09 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        int[] divisorArr = Arrays
                .stream(scan.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        Predicate<Integer> isDivisibleByAll = x -> {
//            boolean result = true;
            for (int divisor : divisorArr) {
                if (x % divisor != 0) {
                    return false;
                }
            }
            return true;
        };


        for (int i = 1; i <= n; i++) {
//            boolean isDivByAll = true;
//            for (int divisor : divisorArr) {
//                if (i % divisor != 0) {
//                    isDivByAll = false;
//                    break;
//                }
//            }
//            if (isDivByAll) {
//                System.out.print(i + " ");
//            }

            if(isDivisibleByAll.test(i)) {
                System.out.print(i + " ");
            }
        }
    }
}
