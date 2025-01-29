package Week3_Functional_Programming.Exer;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CustomComparator_08 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<Integer> numList = Arrays.stream(scan.nextLine().split("\\s+"))
                .map(num -> Integer.parseInt(num))
                .collect(Collectors.toList());

        Comparator<Integer> customComparator = ((n1, n2) -> {
            // 2, 3
            // even - odd = no change, return -1
            if (n1 %2 == 0 && n2 % 2 != 0) {
                return -1;
            } else if (n1 % 2 != 0 && n2 % 2 == 0) {
                return 1;
            } else {
                return n1.compareTo(n2);
            }
        });

        numList.stream().sorted(customComparator).forEach(num -> System.out.print(num + " "));
    }
}
