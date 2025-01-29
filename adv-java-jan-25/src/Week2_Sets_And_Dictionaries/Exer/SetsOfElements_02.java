package Week2_Sets_And_Dictionaries.Exer;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class SetsOfElements_02 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] input = scan.nextLine().split("\\s+");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        Set<Integer> nSet = new LinkedHashSet<>();
        Set<Integer> mSet = new LinkedHashSet<>();

        for (int i = 0; i < n + m; i++) {
            if (i < n) {
                nSet.add(Integer.parseInt(scan.nextLine()));
            } else {
                mSet.add(Integer.parseInt(scan.nextLine()));
            }
        }

//        nSet.forEach(el -> {
//            if (mSet.contains(el)) {
//                System.out.print(el + " ");
//            }
//        });
        // Option two
        nSet.retainAll(mSet);
        nSet.forEach(el -> System.out.print(el + " "));
    }
}
