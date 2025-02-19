package Week4_IteratorsAndComparators.Exer.Froggy;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Lake lake = new Lake(Arrays.stream(scan.nextLine().split(", "))
                .map(Integer::parseInt)
                .toList());

//        scan.nextLine();

        StringBuilder sb = new StringBuilder();
        for(Integer n : lake) {
            sb.append(n).append(", ");
        }

        System.out.println(sb.substring(0, sb.length() - 2));
    }
}
